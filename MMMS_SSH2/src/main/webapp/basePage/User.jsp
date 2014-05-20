<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人员维护</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="<%=basePath%>extjs4.1.1/ext-all.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>extjs4.1.1/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=basePath%>extjs4.1.1/ext-lang-zh_CN.js"></script>

<script language="javascript" type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.0.min.js"></script>

<script type="text/javascript">
	Ext.onReady(function() {
		Ext.QuickTips.init();

		Ext.define('UserModel', {
			extend : 'Ext.data.Model',
			fields : [ {
				name : 'id',
				type : 'int'
			}, {
				name : 'age',
				type : 'int'
			}, {
				name : 'name',
				type : 'string'
			} ]
		});

		Ext.define('UserStore', {
			extend : 'Ext.data.Store',
			model : 'UserModel',
			autoLoad : false,
			remoteSort : true,
			pageSize : 50,
			proxy : {
				type : 'ajax',
				url : "<%=basePath%>demo/getUser.action",
				reader : {
					type : 'json',
					idProperty : 'id',
					root : 'data',
					totalProperty : 'total',
					successProperty : 'success',
					messageProperty : 'message'
				}
			}
		});

		Ext.define('UserGrid', {
			extend : 'Ext.grid.Panel',
			store : Ext.create(UserStore),

			tbar : [ {
				text : 'load',
				handler : function(btn) {
					btn.up('grid').store.load();
				}
			}, {
				text : 'add',
				handler : function(btn) {
					$.ajax({
						type : 'post',
						url :"<%=basePath%>demo/addUser.action",
						dataType : 'json',
						data : {
							"data" : Ext.encode({
								//id : 10, 
								name : 'yunjie.xie',
								age : 30
							})
						},
						success : function(msg) {
							btn.up('grid').store.load();
						}
					});
				}
			},{
				text:'update',
				handler:function(btn){
					var r = btn.up('gridpanel').selModel.selected.items[0];
					if(Ext.isEmpty(r)){
						return;
					}
					
					r.set('age',r.data.age + 3);
					
					$.ajax({
						type : 'post',
						url :"<%=basePath%>demo/updateUser.action",
						dataType : 'json',
						data : {
							"data" : Ext.encode(r.data)
						},
						success : function(msg) {
							btn.up('grid').store.load();
						}
					});
				}
			} ],

			columns : [ {
				text : 'id',
				dataIndex : 'id'
			}, {
				text : 'age',
				dataIndex : 'age'
			}, {
				text : 'name',
				dataIndex : 'name'
			}, ]

		});

		var panel = Ext.create('UserGrid', {
			title : 'bbb',
			height : 500,
			width : 600
		});

		panel.render(document.body);

	});
</script>

</head>
<body>

</body>
</html>