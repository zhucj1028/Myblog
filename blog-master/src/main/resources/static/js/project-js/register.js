let registerApp = new Vue({
    el: '#registerApp',
    methods: {
        register:function(){
             // alert("准备注册");
            $.ajax({
                url: "/api/v1/users/register",
                data: $('#form-register').serialize(),
                type: 'post',
                success:function (json) {
                    console.log(json);
                    if (json.state == 2000) {
                        alert("注册成功");
                        location.href = '/login.html';
                    } else {
                        alert(json.message);
                    }
                }
            });
        }
    }
});