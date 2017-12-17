var privilegeDate = [{
    id: '2',
    pid: '1',
    isParent: true,
	icon:'/style/images/MenuIcon/FUNC20001.gif',
	open:true,
    name: '个人办公',
	nodes:[
		{
			id:'21',
			pid:'2',
			isParent:false,
			icon:'/style/images/MenuIcon/FUNC20054.gif',
			name:'个人考勤'
		},{
			id:'22',
			pid:'2',
			isParent:false,
			icon:'/style/images/MenuIcon/FUNC23700.gif',
			name:'日程安排'
		},{
			id:'23',
			pid:'2',
			isParent:false,
			icon:'/style/images/MenuIcon/FUNC20069.gif',
			name:'工作计划'
		},{
			id:'24',
			pid:'2',
			isParent:false,
			icon:'/style/images/MenuIcon/FUNC20056.gif',
			name:'工作日记'
		},{
			id:'25',
			pid:'2',
			isParent:false,
			icon:'/style/images/MenuIcon/time_date.gif',
			name:'通讯录'
		}
	]
}, {
    id: '3',
    pid: '1',
    name: '审批流转',
	icon:'/style/images/MenuIcon/FUNC20057.gif',
    isParent: true,
	nodes:[
		{
			id:'31',
			pid:'3',
			isParent:false,
			icon:'/style/images/MenuIcon/manager.gif',
			target:'right',
			name:'审批流程管理'
		},{
			id:'32',
			pid:'3',
			isParent:false,
			target:'right',
			icon:'/style/images/MenuIcon/formmodel.gif',
			name:'表单模板管理'
		},{
			id:'33',
			pid:'3',
			isParent:false,
			target:'right',
			icon:'/style/images/MenuIcon/FUNC241000.gif',
			name:'发起申请'
		},{
			id:'34',
			pid:'3',
			isParent:false,
			target:'right',
			icon:'/style/images/MenuIcon/FUNC20029.gif',
			name:'审批处理'
		},{
			id:'35',
			pid:'3',
			target:'right',
			isParent:false,
			icon:'/style/images/MenuIcon/FUNC20029.gif',
			name:'查询状态'
		}
	]
}, {
    id: '4',
    pid: '1',
    name: '知识管理',
	target:'right',
	icon:'/style/images/MenuIcon/FUNC20056.gif',
    isParent: false
},  {
    id: '6',
    pid: '1',
    name: '人力资源',
	icon:'/style/images/MenuIcon/FUNC20001.gif',
    isParent: true,
	nodes:[
		{
			id:'61',
			pid:'6',
			isParent: false,
			icon:'/style/images/MenuIcon/FUNC20076.gif',
			name:'档案管理'
		},{
			id:'62',
			pid:'6',
			isParent: false,
			icon:'/style/images/MenuIcon/FUNC55000.gif',
			name:'培训记录'
		},{
			id:'63',
			pid:'6',
			isParent: false,
			icon:'/style/images/MenuIcon/FUNC55000.gif',
			name:'奖赏记录'
		},{
			id:'64',
			pid:'6',
			isParent: false,
			icon:'/style/images/MenuIcon/FUNC55000.gif',
			name:'职位变更'
		},{
			id:'65',
			pid:'6',
			isParent: false,
			icon:'/style/images/MenuIcon/FUNC55000.gif',
			name:'人事合同'
		},{
			id:'66',
			pid:'6',
			isParent: false,
			icon:'/style/images/MenuIcon/FUNC20001.gif',
			name:'薪酬制度'
		}
	]
},{
    id: '9',
    pid: '1',
    name: '个人设置',
	icon:'/style/images/MenuIcon/FUNC20001.gif',
    isParent: true,
	nodes:[
		{
			id:'91',
			pid:'9',
			name:'个人信息',
			target:'right',
			icon:'/style/images/MenuIcon/FUNC20001.gif',
			isParent:false
		},{
			id:'92',
			pid:'9',
			name:'密码修改',
			target:'right',
			icon:'/style/images/MenuIcon/FUNC241000.gif',
			isParent:false
		}
	]
}, {
    id: '10',
    pid: '1',
    name: '系统管理',
	icon:'/style/images/MenuIcon/system.gif',
    isParent: true,
	nodes:[
		{
			id:'101',
			pid:'10',
			name:'岗位管理',
			target:'right',
			icon:'/style/images/MenuIcon/FUNC20001.gif',
			isParent:false
		},{
			id:'102',
			pid:'10',
			name:'部门管理',
			target:'right',
			icon:'/style/images/MenuIcon/department.gif',
			isParent:false
		},{
			id:'103',
			pid:'10',
			name:'用户管理',
			target:'right',
			icon:'/style/images/MenuIcon/FUNC20001.gif',
			isParent:false
		}
	]
}];
