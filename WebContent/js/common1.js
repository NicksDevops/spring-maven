/**
 * common JS file ------------------
 */
function fixLayout()
{
	 setTimeout(function() {
    	 $('body').layout('fix')
     }, 500);
}

function delayedFocus(targetIdName)
{
	setTimeout(function (e)
			{
		$('#'+targetIdName).focus();
			},300);
}

function removeNullValues(value) {
	if (value != null) {
		return value;
	} else {
		return '';
	}
}

function escapeHtml(text) {
    'use strict';
    if((text != null) && (text != ''))
    	{
    	return text.replace(/[\"&'\/<>]/g, function (a) {
            return {
                '"': '&quot;', '&': '&amp;', "'": '&#39;',
                '/': '&#47;',  '<': '&lt;',  '>': '&gt;'
            }[a];
        });
    	}
    else
    	{
    	return text;
    	}

}
function loadDetailsByAjax(url, type, data) {
	if(url.indexOf('?') == -1)
	{
		url += '?fromAjax=true';
	}
	else
	{
		url += '&fromAjax=true';
	}
	var response;
	$.ajax({
		cache : false,
		url : url,
		type : type,
		data : data,
		async : false,
		cache : false,
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			// $("#loading").hide();
			response = data;
			if(response.isSessionExpired == '1')
			{
				popUpWarningWithCallBack('Session not available', function (e) { logout('/logout') });
			}
		},
		error : function(e) {
			// $("#loading").hide();
			console.log("ERROR: ", e);
		},
		done : function(e) {
			// $("#loading").hide();
			console.log("DONE");
		}
	});
	return response;
}

function refreshComboBox(responseJson, targetId) {
	var target = document.getElementById(targetId);
	removeChild(target);
	addJsonArrayToCombo(responseJson, target);
}

function removeChild(selectObj) {
	var len = selectObj.children.length;
	for (var i = 0; i < len; i++) {
		selectObj.removeChild(selectObj.children[0]);
	}
}

function addJsonArrayToCombo(jsonArray, target) {
	for ( var key in jsonArray) {
		addElementToCombo(jsonArray[key].name, jsonArray[key].id, target);
	}
}

function addElementToCombo(labelToAdd, valueToAdd, selObj) {
	selObj.options[selObj.children.length] = new Option(labelToAdd, valueToAdd);
}

function refreshComboMapBox(responseJson, targetId) {
	var target = document.getElementById(targetId);
	removeChild(target);
	addJsonMapArrayToCombo(responseJson, target);
}

function addJsonMapArrayToCombo(jsonArray, target) {
	for ( var key in jsonArray) {
		if (jsonArray.hasOwnProperty(key)) {
			addElementToCombo(jsonArray[escapeHtml(key)], escapeHtml(key), target);
		}
	}
}

function onlyNumbers(event) {
	var charCode = (event.which) ? event.which : event.keyCode
	if ((charCode > 31) && ((charCode < 48) || (charCode > 57))) {
		alert("Please Provide Numeric Value!!");
		return false;
	}
	return true;
}

function checkAlfaNumeric(str) {
	var charCode = (str.which) ? str.which : str.keyCode
			if (((charCode >=48) && (charCode <=57))|| ((charCode >= 65) && (charCode <= 90)) || ((charCode >= 97) && (charCode <= 122))||(charCode==46)||(charCode == 95) || (charCode == 8)) {

				return true;
			}else{
				alert("Please Provide Alfa Numeric Value!!");
				return false;
			}

}
function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function alertMsg(msgs) {
	var str = msgs[0];
	var i = 0;
	for (i = 1; i < msgs.length; i++) {
		str += "\n[NOTE: " + msgs[i] + "]";
	}
	alert(str);
}

function setTabIndexOrder(tabIndexJson)
{
	var elementIds = tabIndexJson.elementIds;
	if((typeof elementIds != 'undefined') && (elementIds != null) && (elementIds.length > 0))
	{
		var index = 0;
		for(var i = 0 ; i < elementIds.length ; i++)
		{
			$('#'+elementIds[i]).attr('tabindex',i+1);
		}
	}
	var focusOn = tabIndexJson.focusOn;
	if((typeof elementIds != 'undefined') && (elementIds != null))
	{
		setTimeout(function(e)
				{
			$('#'+focusOn).focus();
				},100);

	}
}

function refreshComboBox(responseJson, targetId) {
	var target = document.getElementById(targetId);
	removeChild(target);
	addJsonMapArrayToCombo(responseJson, target);
}

function removeChild(selectObj) {
	var len = selectObj.children.length;
	for (var i = 0; i < len; i++) {
		selectObj.removeChild(selectObj.children[0]);
	}
}

function addJsonMapArrayToCombo(jsonArray, target) {

	for ( var key in jsonArray) {
		if (jsonArray.hasOwnProperty(key)) {
			addElementToCombo(jsonArray[key], key, target);
		}
	}
}

function addElementToCombo(labelToAdd, valueToAdd, selObj) {
	selObj.options[selObj.children.length] = new Option(labelToAdd, valueToAdd);
}
