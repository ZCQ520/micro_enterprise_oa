var privilegeDate = [ {
    id: '1',
    pid: '',
    name: '审批流转',
    icon:'../style/images/MenuIcon/FUNC20057.gif',
    isParent: true,
    nodes:[
        {
            id:'11',
            pid:'1',
            isParent:false,
            icon:'../style/images/MenuIcon/manager.gif',
            target:'right',
            name:'审批流程管理'
        },{
            id:'12',
            pid:'1',
            isParent:false,
            target:'right',
            icon:'../style/images/MenuIcon/formmodel.gif',
            name:'表单模板管理'
        },{
            id:'13',
            pid:'1',
            isParent:false,
            target:'right',
            icon:'../style/images/MenuIcon/FUNC241000.gif',
            name:'发起申请'
        },{
            id:'14',
            pid:'1',
            isParent:false,
            target:'right',
            icon:'../style/images/MenuIcon/FUNC20029.gif',
            name:'审批处理'
        },{
            id:'15',
            pid:'1',
            target:'right',
            isParent:false,
            icon:'../style/images/MenuIcon/FUNC20029.gif',
            name:'查询状态'
        }
    ]
}, {
    id: '2',
    pid: '',
    name: '知识管理',
    target:'right',
    icon:'../style/images/MenuIcon/FUNC20056.gif',
    isParent: false
},{
    id: '3',
    pid: '',
    name: '实用工具',
    icon:'../style/images/MenuIcon/FUNC20076.gif',
    isParent: true,
    nodes:[
        {
            id:'31',
            pid:'3',
            name:'车票预定',
            icon:'../style/images/MenuIcon/FUNC220000.gif',
            isParent:false
        },{
            id:'32',
            pid:'3',
            name:'飞机航班',
            icon:'../style/images/MenuIcon/search.gif',
            isParent:false
        },{
            id:'33',
            pid:'3',
            name:'邮政编码',
            icon:'../style/images/MenuIcon/FUNC249000.gif',
            isParent:false
        }

    ]
},{
    id: '4',
    pid: '',
    name: '个人设置',
    icon:'../style/images/MenuIcon/FUNC20001.gif',
    isParent: true,
    nodes:[
        {
            id:'41',
            pid:'4',
            name:'个人信息',
            target:'right',
            icon:'../style/images/MenuIcon/FUNC20001.gif',
            isParent:false
        },{
            id:'42',
            pid:'4',
            name:'密码修改',
            target:'right',
            icon:'../style/images/MenuIcon/FUNC241000.gif',
            isParent:false
        }
    ]
}, {
    id: '5',
    pid: '',
    name: '系统管理',
    icon:'../style/images/MenuIcon/system.gif',
    isParent: true,
    nodes:[
        {
            id:'51',
            pid:'5',
            name:'岗位管理',
            target:'right',
            icon:'../style/images/MenuIcon/FUNC20001.gif',
            isParent:false
        },{
            id:'52',
            pid:'5',
            name:'部门管理',
            target:'right',
            icon:'../style/images/MenuIcon/department.gif',
            isParent:false
        },{
            id:'53',
            pid:'5',
            name:'用户管理',
            target:'right',
            icon:'../style/images/MenuIcon/FUNC20001.gif',
            isParent:false
        }
    ]
}];
