/**
 *
 * @author ajay
 */

$(document).ready(function(){
    var changePasswordObj = new changePassword();
    changePasswordObj.init();
});

var changePassword = function() {
  privateMethod = {
      attachEventHandler : function() {
          $("#changePasswordForm").validate({
              rules: {
                  oldPassword: {
                      required: true
                  },
                  newPassword: {
                      required: true,
                      maxlength: 20,
                      minlength: 6
                  },
                  confirmPassword: {
                      required: true,
                      equalTo: "#newPassword",
                      maxlength: 20,
                      minlength: 6
                  }
              },
              messages: {
                  oldPassword: {
                      required: MESSAGE_CONSTANT.MESSAGE_REQUIRED_FIELD
                  },
                  newPassword: {
                      required: MESSAGE_CONSTANT.MESSAGE_REQUIRED_FIELD,
                      maxlength: MESSAGE_CONSTANT.MESSAGE_PASSWORD_LESS_THAN_SIX_CHARACTERS,
                      minlength: MESSAGE_CONSTANT.MESSAGE_PASSWORD_LESS_THAN_SIX_CHARACTERS
                  },
                  confirmPassword: {
                      required: MESSAGE_CONSTANT.MESSAGE_REQUIRED_FIELD,
                      maxlength: MESSAGE_CONSTANT.MESSAGE_PASSWORD_LESS_THAN_SIX_CHARACTERS,
                      minlength: MESSAGE_CONSTANT.MESSAGE_PASSWORD_LESS_THAN_SIX_CHARACTERS,
                      equalTo: MESSAGE_CONSTANT.MESSAGE_SHOULD_BE_SAME
                  }
              },
              errorElement: "div",
              wrapper: "div",
              errorPlacement: function (error, element) {
                  offset = element.offset();
                  error.insertAfter(element);
                  error.addClass('errorbox1');
              }

          });
      },
      displayMessage : function() {
          var notifications = new notification();
          notifications.init();
      }
  };
    return {
        init : function() {
            privateMethod.attachEventHandler();
            privateMethod.displayMessage();
        }
    };
};


