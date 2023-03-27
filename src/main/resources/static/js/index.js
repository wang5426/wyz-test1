		$(function(){
			$.ajax({
				url:"user/isLogin",
				type:"post",
				data:{},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					if(data.status == "YES"){
						$("#login").hide();
						$("#main").css("display","block");
						get_user(1);
					}else{
						return ;
					}
				},
				complete:function(){
					$("#m_view").css("display","none");
				}
			});
			$("#btn_exit").click(function(){
				$.ajax({
					url:"user/exit",
					type:"post",
					data:{},
					dataType:"json",
					beforeSend:function(){
						window.location.reload();
					},
					complete:function(){
						$("#m_view").css("display","none");
					}
				});
				
			});
			$("#btn_login").click(function(){
				var userName=$("#userName").val();
				var password=$("#password").val();
				$.ajax({
					url:"user/login",
					type:"post",
					data:{"userName":userName,"password":password},
					dataType:"json",
					beforeSend:function(){
						$("#m_view").css("display","block");
					},
					success:function(data){
						if(data.code == "200"){
							$("#login").hide();
							$("#main").css("display","block");
							get_user(1);
						}else{
							alert("no");
						}
					},
					complete:function(){
						$("#m_view").css("display","none");
					}
					
				});
			});
			
			$("#btn_add1").click(function(){
				var userName=null;
				var password=null;
				$.ajax({
					url:"user/add",
					type:"post",
					data:{},
					dataType:"json",
					beforeSend:function(){
						$("#m_view").css("display","block");
					},
					success:function(data){
						get_user(1);
						$.ajax({
							url:"user/list",
							type:"post",
							data:{},
							dataType:"json",
							beforeSend:function(){
								$("#m_view").css("display","block");
							},
							success:function(data){
								get_user(1);
									
							},
							complete:function(){
								$("#m_view").css("display","none");
								
								var id = $("#tcontent").find("tr:last").children().text();
								var tds = $(id).children("td");
								var u =tds.eq(1).text();
								tds.eq(1).html("<input type='text' id ='u_"+id+"' value='"+u+"'/>");
								var p =tds.eq(2).text();
								tds.eq(2).html("<input type='text' id ='p_"+id+"' value='"+p+"'/>");
								var edit_btn = tds.eq(3).html();
								console.log(edit_btn);
								tds.eq(3).html("<button onclick='btn_ok("+id+");'>ok</button><button onclick='btn_no("+id+",\""+u+"\",\""+p+"\");'>no</button>");
								
							}
							
						});
					},
					complete:function(){
						$("#m_view").css("display","none");
					}
					
				});
			});
		});

		function add_emp_view(){
			var str = "";
			for(var i=0;i<dept_list.length;i++){      //遍历并显示在输入界面
				var item = dept_list[i];
				str+="<option value='"+item.id+"'>"+item.name+"</option>";
			}  
			$("#emp_depts").html(str); //把emp_depts里面的值转换成string类型
			$("#view_emp_add").modal('show');
			//在页面里面的add_emp_submit添加
			
		}
		
		function add_emp_submit(){
			var dept = $("#emp_depts").val();  //取值
			var name = $("#name").val();
			var sex = $("input[name='sex']:checked").val();
			var phone = $("#phone").val();
			var email = $("#email").val();
			var address = $("#address").val();
			var idCard = $("#idCard").val();
			var weChat = $("#weChat").val();
			var notes = $("#notes").val();
			//alert(dept+","+name);
			//$("#view_emp_add").css("display","none")
			//$("#m_view").css("display","none");
			$.ajax({
				url:"emp/insert",  //跳转controller
				type:"post",
				data:{"dept.id":dept,"name":name,"sex":sex,"address":address,"email":email,"phone":phone,"idCard":idCard,"weChat":weChat,"notes":notes},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					$('#view_emp_add').modal('hide'); //成功了就刷新到view_emp_add的页面
					get_emp(1);
				},
				complete:function(){
					$("#m_view").css("display","none");
				}		
						
			});
			
			
			
		}
		function edit_emp_submit(){
			var dept = $("#edit_emp_depts").val();
			var name = $("#edit_name").val();
			var sex = $("input[name='edit_sex']:checked").val();
			var phone = $("#edit_phone").val();
			var email = $("#edit_email").val();
			var address = $("#edit_address").val();
			var idCard = $("#edit_idCard").val();
			var weChat = $("#edit_weChat").val();
			var notes = $("#edit_notes").val();
			var id = $("#edit_emp_id").val();
			
			$.ajax({
				url:"emp/update",
				type:"post",
				data:{"dept.id":dept,"name":name,"sex":sex,"address":address,"email":email,"phone":phone,"idCard":idCard,"weChat":weChat,"notes":notes,"id":id},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					$('#view_emp_edit').modal('hide');
					get_emp(1);
				},
				complete:function(){
					$("#m_view").css("display","none");

				}		
						
			});
			
			}
		
		function edit_emp(id){
			
			
			
			$.ajax({
				url:"emp/edit",
				type:"post",
				data:{"id":id},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					var dept = data.data.dept.id;
					var str = "";
					for(var i=0;i<dept_list.length;i++){
						var item = dept_list[i];
						if(item.id == dept){
							str+="<option value='"+item.id+"' selected>"+item.name+"</option>";
						}else{
							str+="<option value='"+item.id+"'>"+item.name+"</option>";
						
					}
					$("#edit_emp_depts").html(str);
					if(data.data.sex == '女'){
						$("input[name='edit_sex'][value='女']").attr('checked','true');
						$("input[name='edit_sex'][value='男']").removeAttr('checked');
						$("input[name='edit_sex']").get(1).checked=true;
					}else{
						$("input[name='edit_sex'][value='男']").attr('checked','true');
						$("input[name='edit_sex'][value='女']").removeAttr('checked');
						$("input[name='edit_sex']").get(0).checked=true;
					}
					$("input[name='edit_sex']:checked").val();
					
					$("#edit_name").val(data.data.name);
					
					$("#edit_phone").val(data.data.phone);
					$("#edit_email").val(data.data.email);
					$("#edit_address").val(data.data.address);
					$("#edit_idCard").val(data.data.idCard);
					$("#edit_weChat").val(data.data.weChat);
					$("#edit_notes").val(data.data.notes);
					$("#edit_emp_id").val(id);
					}
				},
				complete:function(){
					$("#m_view").css("display","none");
				}		
						
			});
			
			$("#view_emp_edit").modal('show');
		
			
		}
		function get_emp(page){
			$("#user_view").hide();
			$("#emp_view").show();
			$("#groups_view").hide();
			$.ajax({
				url:"emp/list",
				type:"post",
				data:{"page":page},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					var str="";
					$.each(data.list,function(i,item){
						str+="<tr id='tr_user_"+item.id+"'><td>"+item.id+"</td><td>"+item.dept.name+"</td><td>"+item.name+"</td><td>"+item.sex+"</td><td>"+item.phone+"</td><td>"+item.email+"</td><td>"+item.address+"</td><td>"+item.idCard+"</td><td>"+item.weChat+"</td><td>"+item.notes+"</td><td><span onclick='edit_emp("+item.id+");' class='glyphicon glyphicon-edit'></span></td><td><span onclick='delete_emp("+item.id+");' class='glyphicon glyphicon-remove'></span></td></tr>";
					});
					$("#emps").html(str);
					var pageStr = "";
					if(data.currentPage == 1){
						pageStr+="<li class='disabled'><a href='#'>首页</a></li>";
						pageStr+="<li class='disabled'><a href='#'>上一页</a></li>";
					}else{
						pageStr+="<li><a href='javascript:void(0)' onclick='get_user(1)'>首页</a></li>";
						pageStr+="<li><a href='javascript:void(0)' onclick='get_user("+(data.currentPage-1)+")'>上一页</a></li>";
					}
					if(data.surrenPage == data.totalPage){
						pageStr+="<li class='disabled'><a href='#'>下一页</a></li>";
						pageStr+="<li class='disabled'><a href='#'>尾页</a></li>";
					}else{
						pageStr+="<li><a href='javascript:void(0)' onclick='get_user("+(data.currentPage+1)+")'>下一页</a></li>";
						pageStr+="<li><a href='javascript:void(0)' onclick='get_user("+(data.totalPage)+")'>尾页</a></li>";
					}
					pageStr+="<li class='disabled'><a href='#'>当前"+data.currentPage+"页</a></li>";
					pageStr+="<li class='disabled'><a href='#'>总"+data.totalPage+"页</a></li>";
					pageStr+="<li class='disabled'><a href='#'>总"+data.total+"记录</a></li>";
					$("#emp_pages").html(pageStr);
				},
				complete:function(){
					$("#m_view").css("display","none");
				}			
			});
		}