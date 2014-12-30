var COMMAN_METHOD = {
	isContainsSpecialCharacter : function(inputText){
		var pattern = new RegExp(REGEX_CONSTANT.SPECIAL_CHARACTERS);
		return pattern.test(inputText);
	},
	
	appendMessageToElement : function(elementId , message){
		$("#" + elementId).text(message);
	},
	
	isValidEmailAddress : function(emailAddress){
		var pattern = new RegExp(REGEX_CONSTANT.EMAIL_ADDRESS);
		return pattern.test(emailAddress);
	},
	
	clearElementValue : function(elementId){
		$("#" + elementId).text("");
	},
	
	isValidName : function(inputText){
		var pattern = new RegExp(REGEX_CONSTANT.NAME);
		console.log(pattern.test(inputText))
		return pattern.test(inputText);
	}
};
 