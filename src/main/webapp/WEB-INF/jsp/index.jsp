<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />

</head>
<body>
<div class="accordion">
<input id="collapse1" type="radio" name="tap-input" hidden />
<input id="collapse2" type="radio" name="tap-input" hidden />
<input id="collapse3" type="radio" name="tap-input" hidden />
<article>
<label for="collapse1">列表1</label>
<p>内容1<br>内容2<br>内容3<br>内容4</p>
</article>
<article>
<label for="collapse2">列表2</label>
<p>内容1<br>内容2<br>内容3<br>内容4</p>
</article>
<article>
<label for="collapse3">列表3</label>
<p>内容1<br>内容2<br>内容3<br>内容4</p>
</article>
</div>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
		var dept_list = [];
		$(function(){
			get_user(1);
			$("#emp_view").hide();
			$("#groups_view").hide();
			$.ajax({
				url:"dept/list_all",
				type:"post",
				data:{},
				dataType:"json",
				
				success:function(data){
					//var str = "";
					$.each(data,function(i,item){
						//str+="<option value='"+item.id+"'>"+item.name+"</option>";
						var obj = new Object;
						obj.id = item.id;
						obj.name = item.name;
						dept_list.push(obj);
						});
					//$("#emp_depts").html(str);
				}
						
			});
			
			
			
			
			var page = 1;
			
		
			
		});
		function delete_groups(){
			$.ajax({
				url:"groups/delete",
				type:"post",
				data:{"id":id},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					
					$("#btn_groups").click();
					get_groups(1); //刷新网页
				},
				complete:function(){
					$("#m_view").css("display","none");
				}			
			});
		}
		
		function groups_emps_add(groups,emps){
			$.ajax({
				url:"groups/groups_emps_add",
				type:"post",
				data:{"groups":groups,"emps":emps},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					groups_emps(groups);
				},
				complete:function(){
					$("#m_view").css("display","none");
					$("#view_groups_emps").modal('show');
				}
				
			});
				
		}
		function groups_emps_del(groups,emps){
			$.ajax({
				url:"groups/groups_emps_del",
				type:"post",
				data:{"groups":groups,"emps":emps},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					groups_emps(groups);
				},
				complete:function(){
					$("#m_view").css("display","none");
					$("#view_groups_emps").modal('show');
				}
				
			});
				
		}
		
		function groups_emps(groups){
			$.ajax({
				url:"groups/groups_emps_list",
				type:"post",
				data:{"groups":groups},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					var str = "";
					$.each(data.emps,function(i,item){
						str+="<button type='button' style='margin:5px 10px 0px 0px;' class='btn btn-success' onclick='groups_emps_del("+groups+","+item.id+");'>"+item.name+"</button>"
					});
					$("#emps_list").html(str);
					var str = "";
					$.each(data.not_emps,function(i,item){
						str+="<button type='button' style='margin:5px 10px 0px 0px;' class='btn btn-primary' onclick='groups_emps_add("+groups+","+item.id+");'>"+item.name+"</button>"
					});
					$("#not_emps_list").html(str);
				},
				complete:function(){
					$("#m_view").css("display","none");
					$("#view_groups_emps").modal('show');
				}
				
			});
			
		}
		
		function get_groups(page){
			$("#emp_view").hide();
			$("#user_view").hide();
			$("#groups_view").show();
			$.ajax({
				url:"groups/list",
				type:"post",
				data:{"page":page},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
						var str="";
						$.each(data.list,function(i,item){
							str+="<tr><td>"+item.id+"</td><td>"+item.name+"</td><td>"+item.notes+"</td><td><a href='javascript:void(0);' onclick='groups_emps("+item.id+");'>分配</a></td><td><span onclick='edit_groups("+item.id+");' class='glyphicon glyphicon-edit'></span></td><td><span onclick='delete_groups("+item.id+");' class='glyphicon glyphicon-remove'></span></td></tr>";
						});
						$("#groups").html(str);
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
						$("#groups_pages").html(pageStr);
						
				},
				complete:function(){
					$("#m_view").css("display","none");
				}
				
			});
		}
		
		function get_user(page){
			$("#user_view").show();
			$("#emp_view").hide();
			$("#groups_view").hide();
				$.ajax({
					url:"user/list",
					type:"post",
					data:{"page":page},
					dataType:"json",
					beforeSend:function(){
						$("#m_view").css("display","block");
					},
					success:function(data){
							var str="";
							$.each(data.list,function(i,item){
								str+="<tr id='tr_user_"+item.id+"'><td>"+item.id+"</td><td>"+item.userName+"</td><td>"+item.password+"</td><td><span onclick='edit_user("+item.id+");' class='glyphicon glyphicon-edit'></span></td><td><span onclick='delete_user("+item.id+");' class='glyphicon glyphicon-remove'></span></td></tr>";
							});
							$("#users").html(str);
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
							$("#pages").html(pageStr);
							
					},
					complete:function(){
						$("#m_view").css("display","none");
					}
					
				});
			
		}
		
		function edit_user(id){
			var tds = $("#tr_user_"+id).children("td");
			var u =tds.eq(1).text();
			tds.eq(1).html("<input type='text' id ='u_"+id+"' value='"+u+"'/>");
			var p =tds.eq(2).text();
			tds.eq(2).html("<input type='text' id ='p_"+id+"' value='"+p+"'/>");
			var edit_btn = tds.eq(3).html();
			console.log(edit_btn);
			tds.eq(3).html("<button onclick='btn_ok("+id+");'>ok</button><button onclick='btn_no("+id+",\""+u+"\",\""+p+"\");'>no</button>");
		}
		
		function geek(){
			$('table tr:last').css("background-color","red")
		}
		function delete_emp(id){
			$.ajax({
				url:"emp/delete",
				type:"post",
				data:{"id":id},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					
					$("#btn_emp").click();
					get_emp(1); //刷新网页
				},
				complete:function(){
					$("#m_view").css("display","none");
				}			
			});
			
		}
		function delete_user(id){
			$.ajax({
				url:"user/delete",
				type:"post",
				data:{"id":id},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					location.reload(true); //刷新网页
					$("#btn_users").click();
				},
				complete:function(){
					$("#m_view").css("display","none");
				}			
			});
		}
		function btn_no(id,u,p){
			var tds = $("#tr_user_"+id).children("td");
			tds.eq(1).html(u);
			tds.eq(2).html(p);
			tds.eq(3).html("<span onclick='edit_user("+id+");' class='glyphicon glyphicon-edit'></span>");
		}
		function btn_ok(id){
			var userName = $("#u_"+id).val();
			var password = $("#p_"+id).val();
			$.ajax({
				url:"user/edit",
				type:"post",
				data:{"userName":userName,"password":password,"id":id},
				dataType:"json",
				beforeSend:function(){
					$("#m_view").css("display","block");
				},
				success:function(data){
					btn_no(id,userName,password);
				},
				complete:function(){
					$("#m_view").css("display","none");
				}
				
			});
		}
	</script>
</body>
</html>