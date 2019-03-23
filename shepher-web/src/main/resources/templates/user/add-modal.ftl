<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    ADD User <span id="grant-permission"></span>
                </h4>
            </div>
            <form class="form-horizontal" id="add-form" action="/user/add" method="post">
                <div class="modal-body">
                    <fieldset>

                        <div class="form-group">
                            <label for="UserName" class="col-lg-2 control-label">UserName</label>
                            <div class="col-lg-8 ">
                                <input name="username" type="text" class="form-control input-sm"
                                       placeholder="UserName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Password" class="col-lg-2 control-label">Password</label>
                            <div class="col-lg-8">
                                <input name="password" type="text" class="form-control input-sm" placeholder="Password">
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">
                        Confirm
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        Cancel
                    </button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->