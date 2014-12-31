/**
 *
 * @author ajay
 */

var notification = function() {
	privateMethod = {
			displayMessage : function(type, fieldId) {

                if ($("#"+fieldId).val().length > 0)
				showNotification({
                      message: $("#"+fieldId).val(),
                      autoClose: true,
                      duration: 3,
                      type : type
                  });
                
                $("#"+fieldId).val('');
                
		}// closing display method

	};// closing private method

	return {
		init : function() {
			privateMethod.displayMessage("success", "successMessage");
			privateMethod.displayMessage("error", "errorMessage");
		}
	};
};// closing profileOperation object
