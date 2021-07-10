$(document).ready(function () {
    $('#myTab li:last-child a').tab('show');
    $('input[name=password]').change(function () {
        let pattern = $(this).val().replace(/([*.?+$^\[\](){}|\/\\])/g, '\\$1');
        $('#password-confirm').attr('pattern', pattern);
    });
    setLoginRegister('register');
});