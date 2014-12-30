var URL_CONSTANT = {
	LIST_PAGINATED_USERS_URL:window.location.protocol+"//"+ window.location.host+"/user/list/view",
	DELETE_USER_URL:window.location.protocol+"//"+ window.location.host+"/user/delete"
};

var MESSAGE_CONSTANT = {
	MESSAGE_NO_USER_FOUND : "No user found",
	MESSAGE_REQUIRED_FIELD : "This is a required field",
	MESSAGE_SELECT_ROLE : "Select Role",
	MESSAGE_SPECIAL_CHARACTER_NOT_ALLOWED : "Special characters not allowed",
	MESSAGE_ENTER_VALID_EMAIL : "Enter valid email",
	MESSAGE_PASSWORD_LESS_THAN_SIX_CHARACTERS : "Password should be at least 6 characters long"
};

var TEXT_CONSTANT = {
	EDIT : "Edit",
	DELETE : "Delete",
	NEXT : 'Next', 
	PREV : 'Prev', 
	FIRST : 'First', 
	LAST : 'Last'
};

var REGEX_CONSTANT = {
	NAME : /^[a-zA-Z '.-]*$/,
	SPECIAL_CHARACTERS : /[-!$%^&*()_+|~=`{}\[\]:";'<>?,.\/]/,
	EMAIL_ADDRESS : /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i
};