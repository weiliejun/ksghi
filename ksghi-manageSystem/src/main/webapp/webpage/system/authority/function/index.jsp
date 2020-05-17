<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.itech-ups.com/jsp/taglibs" prefix="itech" %>
<!DOCTYPE html>
<html>
<head>
    <title>功能管理</title>
    <%@ include file="/webpage/common/public.jsp" %>
    <%@ include file="/webpage/common/plugins/ztree.jsp" %>
</head>

<body>
<div id="wrapper">
    <div id="breadcrumb-wrapper">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li><i class="icon-home"></i>系统管理</li>
                <li>管理员权限管理</li>
                <li class="active">功能管理</li>
            </ul>
        </div>
    </div>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 page-header">
                    <h4>系统功能树</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <ul id="functionTree" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- *********** add or update  Modal ***********  -->
<div class="modal fade " id="nodeModal" tabindex="-1" role="dialog"
     aria-labelledby="top_ModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form class="form-horizontal"
                  action="${pageContext.request.contextPath}/system/authority/function/submit"
                  id="addNodeForm" method="post">
                <input type="hidden" name="id" id="id"/>
                <input type="hidden" name="operation" id="operation"/>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="top_ModalLabel">新增菜单</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="parentCode" class="col-sm-4 control-label">父级菜单编码：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="parentCode"
                                   name="parentCode" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="parentName" class="col-sm-4 control-label">父级菜单名称：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="parentName"
                                   name="parentName" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">  <!-- 注：菜单编号是树节点的id，保证唯一，不能修改的  -->
                        <label for="code" class="col-sm-4 control-label"><i
                                class="icons-mark-required"></i>菜单编号：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="code" name="code"
                                   placeholder="请输入菜单编号" size="30" maxlength="30">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-4 control-label"><i
                                class="icons-mark-required"></i>菜单名称：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入菜单名称" size="30" maxlength="30">
                        </div>
                    </div>
                    <div class="form-group" id="urlDiv">
                        <label for="url" class="col-sm-4 control-label"><i
                                class="icons-mark-required"></i>菜单URL：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="url" name="url"
                                   placeholder="请输入URL">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="status" class="col-sm-4 control-label"><i
                                class="icons-mark-required"></i>是否有效：</label>
                        <div class="col-sm-6">
                            <itech:code property="status" code="status" type="radio"
                                        defaultValue="valid"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nodeTypePro" class="col-sm-4 control-label"><i
                                class="icons-mark-required"></i>节点类型：</label>
                        <div class="col-sm-6">
                            <itech:code property="nodeTypePro" code="sysMenu.nodeType"
                                        type="select"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="seqnum" class="col-sm-4 control-label"> <i
                                class="icons-mark-required"></i>菜单序号：
                        </label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="seqnum"
                                   name="seqnum" placeholder="请输入菜单序号">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="nodeSubmit">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Modal End -->

</body>


<script type="text/javascript">
    //树属性的定义
    var setting = {
        view: {
            selectedMulti: false,
            addHoverDom: addHoverDom, //当鼠标移动到节点上时，显示用户自定义控件
            removeHoverDom: removeHoverDom,//离开节点时的操作
            dblClickExpand: false
        },
        edit: {
            enable: true, //单独设置为true时，可加载修改、删除图标
            showRenameBtn: true,
            renameTitle: "修改",
            showRemoveBtn: true,
            removeTitle: "删除"
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                system: "system",
                rootPId: ""
            }
        },

        callback: {
            beforeRemove: beforeRemove,//点击删除时触发，用来提示用户是否确定删除
            onRemove: onRemove,//删除节点后触发，用户后台操作
            beforeEditName: beforeEditName
        }
    };

    //新增模态框-Form校验
    var addNodeFormValidate = $("#addNodeForm").validate({
        rules: {
            name: {
                required: true
            },
            code: {
                required: true,
                remote: {//--false提示信息
                    url: '${pageContext.request.contextPath}/system/authority/function/isCodeExist',
                    type: "GET",
                    dataType: "json",
                    data: {
                        "code": function () {
                            var code = $("#code").val().trim();
                            return encodeURI(code);
                        }
                    }
                }
            },
            seqnum: {
                required: true
            },
            url: {
                required: true
            },
            status: {
                required: true
            },
            nodeTypePro: {
                required: true
            }
        },
        messages: {
            code: {
                remote: '当前编号已存在'
            }

        }
    });
    //修改模态框-Form校验
    var editNodeFormValidate = $("#addNodeForm").validate({
        rules: {
            name: {
                required: true
            },
            seqnum: {
                required: true
            },
            url: {
                required: true
            },
            status: {
                required: true
            },
            nodeTypePro: {
                required: true
            }
        }
    });
    var zNodes = [${treeText}];
    $(document).ready(function () {
        //初始化tree
        $.fn.zTree.init($("#functionTree"), setting, zNodes);
        //模态框button提交数据库
        $("#nodeSubmit").click(function () {
            var flag;
            if ($("#operation").val() == 'add') {
                flag = addNodeFormValidate.form();
            } else if ($("#operation").val() == 'edit') {
                flag = editNodeFormValidate.form();
            }
            if (flag) {
                //if(addNodeFormValidate.form()){
                $.ajax({
                    url: '${pageContext.request.contextPath}/system/authority/function/submit',
                    type: "post",
                    async: false,
                    dataType: "json",
                    data: $("#addNodeForm").serialize(),
                    success: function (data) {
                        if (data != null && data.length != 0) {
                            var newName = data.record.name;
                            var newCode = data.record.code;
                            var zTree = $.fn.zTree.getZTreeObj("functionTree");
                            var node = zTree.getNodeByParam("id", newCode, null);
                            if (data.operation == "edit") {
                                node.name = newName;
                                zTree.updateNode(node);
                                zTree.selectNode(node);
                            } else if (data.operation == "add") {
                                var pId = data.record.parentCode;
                                var pTreeNode = zTree.getNodeByParam("id", pId, null);
                                zTree.addNodes(pTreeNode, {id: newCode, name: newName, pId: pId});
                                zTree.selectNode(node);
                            }
                            bootbox.alert("成功");
                            $("#nodeModal").modal('hide');

                        } else {
                            $("#nodeModal").modal('hide');
                            bootbox.alert("请求出现异常");
                        }
                    },
                    error: function () {
                        $("#nodeModal").modal('hide');
                        bootbox.alert("请求出现异常");
                    }
                });
            }
        });

    });

    //事件：增加
    function addHoverDom(treeId, treeNode) {
        var aObj = $("#" + treeNode.tId + "_a");
        if ($("#diyBtn_" + treeNode.id).length > 0) return;
        if ("submodule" != treeNode.nodeType.toLowerCase()) {
            var editStr = "<span class='button add' id='diyBtn_" + treeNode.id + "' title='新增' style='margin-right: 2px; background-position: -143px 0px; vertical-align: top;'></span>";
            aObj.append(editStr);
            //点击[add]，弹出模态框
            var span = $("#diyBtn_" + treeNode.id);
            if (span) span.bind("click", function () {

                $('#nodeModal').on('show.bs.modal', function (event) {
                    var modal = $(this);
                    modal.find('.modal-title').text('新增菜单');
                    modal.find('#parentCode').val(treeNode.id);
                    modal.find('#parentName').val(treeNode.name);
                    modal.find('#operation').val('add');

                });
                $('#nodeModal').modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
                $("#nodeModal").on('shown.bs.modal',
                    function (e) {
                        $('#code').focus()
                    }
                );
                $("#nodeModal").on('hidden.bs.modal',
                    function (e) {
                        $("#code").removeAttr("readonly");
                        clearForm($('#addNodeForm'));
                        // addNodeFormValidate.resetForm();
                        $("#addNodeForm").validate().resetForm();
                    }
                );
                $(":input[name='code']").rules("add", {
                    required: true,
                    remote: {//--false提示信息
                        url: '${pageContext.request.contextPath}/system/authority/function/isCodeExist',
                        type: "GET",
                        dataType: "json",
                        data: {
                            "code": function () {
                                var code = $("#code").val().trim();
                                return encodeURI(code);
                            }
                        }
                    },
                    messages: {remote: '当前编号已存在'}
                });
                /*  int count = 0 ;
                 $("#myModal").on("loaded.bs.modal",function{
                 if(++count == 1){
                 //调用你需要的方法
                 }
                 //在模态框加载的同时做一些动作
                 }); */
            });
        }
    };

    //事件：移除
    function removeHoverDom(treeId, treeNode) {
        $("#diyBtn_" + treeNode.id).unbind().remove();
    };

    //事件：编辑
    function beforeEditName(treeId, treeNode) {
        if (treeNode.id == 'root') {
            bootbox.alert("不准编辑根节点！");
            return false;
        } else if (treeNode.isParent) {
            $("#urlDiv").hide();
        }
        $(":input[name='code']").rules("remove");
        //查询记录信息
        getFunctionData(treeNode.id, "edit");
        return true;
    }

    //事件：before删除
    function beforeRemove(treeId, treeNode) {
        if (treeNode.id == 'root') {
            bootbox.alert("不准删除根节点！");
            return false;
        } else {
            return confirm("你确定要删除吗？");
        }
    }

    //事件：删除
    function onRemove(e, treeId, treeNode) {
        console.log("remove");
        $.ajax({
            url: '${pageContext.request.contextPath}/system/authority/function/removeNode',
            type: "post",
            async: false,
            dataType: "json",
            data: {"code": treeNode.id},
            success: function (data) {
                if (data.flag == "true") {
                    bootbox.alert("删除成功！");

                } else {
                    bootbox.alert("请求出现异常");
                }
            },
            error: function () {
                bootbox.alert("请求出现异常");
            }
        });
    }

    /* 根据treeNode.id（code） 查询function信息 */
    function getFunctionData(code, operation) {
        $.ajax({
            async: true,
            type: "post",
            url: pageContext.contextPath + "/system/authority/function/details",
            dataType: "json",
            data: {
                "code": code,
                "operation": operation
            },
            success: function (data) {
                $("#parentCode").val(data.parentCode);
                $("#parentName").val(data.parentName);
                $("#code").val(data.code);
                $("#code").attr("readonly", "readonly");
                $("#name").val(data.name);
                $("#url").val(data.url);
                $("#nodeTypePro").val(data.nodeType);
                $("#seqnum").val(data.seqnum);
                $("#id").val(data.id);
                // $("#operation").val("edit");
                $('#nodeModal').on('show.bs.modal', function (event) {
                    var modal = $(this);
                    modal.find('.modal-title').text('修改菜单');
                    modal.find('#operation').val('edit');
                });
                $('#nodeModal').modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
                $("#nodeModal").on('hidden.bs.modal', function (e) {
                        $("#urlDiv").show();
                        $("#code").removeAttr("readonly");
                        $(this).removeData("bs.modal");
                        clearForm($('#addNodeForm'));
                        //addNodeFormValidate.resetForm();
                        $("#addNodeForm").validate().resetForm();
                    }
                );
            },
            error: function () {
                bootbox.alert("请求失败，请刷新页面后重试！");
                return false;
            }
        });
    }

    //清空文本框内容
    function clearForm(form) {
        // input清空
        $(':input', form).each(function () {
            var type = this.type;
            var tag = this.tagName.toLowerCase(); // normalize case
            if (type == 'text' || type == 'hidden' || type == 'password' || tag == 'textarea')
                this.value = "";
            // 多选checkboxes清空
            // select 下拉框清空
            else if (tag == 'select')
                this.selectedIndex = 0;

        });
    };

    function removeRule(obj) {
        $(obj).rules("remove");
    }

    $("#nodeTypePro").change(function () {
        if ($("#nodeTypePro").val() && "submodule" != $("#nodeTypePro").val().toLowerCase()) {
            $("#nodeTypePro").rules("remove");
            $("#urlDiv").hide();
        } else {
            $("#nodeTypePro").rules("add", {required: true});
            $("#urlDiv").show();
        }
    })

</script>
</html>
