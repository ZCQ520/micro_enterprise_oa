var kynamic = {
    /**
     * 凡是树的操作
     */
    kynamicTree: {
        pNode: '',
        zTree: '',
        setting: {
            isSimpleData: true,
            treeNodeKey: "id",
            treeNodeParentKey: "pid",
            isParent:"isParent",
            //keepParent:true,
            showLine: true,
            root: {
                isRoot: true,
                nodes: []
            },
            callback: {
                /**
                 * kynamic节点的点击事件
                 */
                click: function(event, treeId, treeNode){
                    /**
                     * 因为在单击的时候，右键事件不一定发生了，所以得重新给pNode赋值
                     */
                    kynamic.kynamicTree.pNode = treeNode;
                    if (kynamic.kynamicTree.pNode.isParent){
                        var parameter = {
                            id: kynamic.kynamicTree.pNode.id
                        };
                        $.post("/LanDiskFolder/showCurrentNodeList", parameter, function(data){
                            if (data.versionList.length == 0) {//没有版本
                            }
                            else {//有版本
                                //控制div和checkin和checkout按钮的显示
                                kynamic.version.controlShowVersion({
                                    addVersion: false,
                                    versionList: true,
                                    checkin: false,
                                    checkout: false
                                });
                                kynamic.version.showVersionsByKID(data.versionList);
                            }
                        });
                    }
                }
            }
        },
        loadKynamicTree:function(){
            $.post("/LanDiskFolder/showKynamicTree",null,function(data){
               kynamic.kynamicTree.zTree = $("#kynamicTree").zTree(kynamic.kynamicTree.setting,data)
            })
        }
    }
};

$().ready(function(){
    kynamic.kynamicTree.loadKynamicTree();
});

