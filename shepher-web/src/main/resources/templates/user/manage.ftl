<#setting datetime_format="yyyy-MM-dd HH:mm:ss"/>
<!DOCTYPE html>
<html lang="en">
<#include "../header.ftl">
<body>
<#include "../nav.ftl">

<div class="container">
    <div>
        <form id="form-manage" action="?" method="POST">
            <table class="table table-striped">
                <caption class="caption"><h4>Super Admin Management</h4></caption>
                <thead>
                <tr>
                    <th class="col-md-3">Id</th>
                    <th class="col-md-3">UserName</th>
                    <th class="col-md-3">Time</th>

                </tr>
                </thead>
                <tbody>
                <#list userlist as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.time?string('yyyy-MM-dd HH:mm')}</td>
                    <td>
                        <button class="btn btn-danger btn-xs" id="delete-button"
                                onclick="onButtonClick(this.form, '/user/delete', 'POST', ${user.id?c})">Delete
                        </button>
                        <button class="btn btn-success btn-xs" id="modify-button"
                                onclick="showUpdateModal(${user.id?c}, '${user.name}'); return false">Modify
                        </button>
                    </td>
                </tr>
                </#list>

                </tbody>
            </table>
            <input name="id" id="id" hidden="hidden"></input>
        </form>
    </div>
     <button class="btn btn-success btn-sm pull-right" id="add-button"
                    onclick="showModal('#addModal');return false;">Add User
     </button>
</div>

<!-- /container -->

<!-- 模态框（Modal） -->
<#include "add-modal.ftl">
<#include "update-modal.ftl">

<#include "../script.ftl">
<script>
    function onButtonClick(form, action, method, id) {
        form.action = action;
        form.method = method;
        $("#id").val(id);
        form.submit();
    }
     function showUpdateModal(id, username, password) {
            $('#update-permission').attr('value', id);
            $('#user-username').attr('value', username);
            $('#updateModal').modal({
                keyboard: true
            })
        }
</script>

</body>
</html>
