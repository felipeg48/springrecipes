/***
 * Controller to handle interfacing with the RESTful endpoint
 */
$.ajaxSetup({
    cache:false
});

var utils = {
    _url:'',
    setup:function (u) {
        this._url = u;
    },
    url:function (u) {
       return this._url + u;
    },
    get:function (url, data, cb) {
        $.ajax({
            type:'GET',
            url:url,
            cache:false,
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:cb,
            error:function (u) {
                alert('error trying to retrieve ' + u);
            }
        });
    },
    post:function (u, data, cb) {
        $.ajax({
            type:'POST',
            url:u,
            cache:false,
            // headers : getAuthorizationHeader(),
            dataType:'json',
            data:data,
            contentType:'application/json; charset=utf-8',
            success:cb,
            error:function (u) {
                alert('error trying to post to ' + u);
            }
        });
    }
};

function CustomerCtrl($scope) {

    $scope.isCustomerLoaded = function () {
	if ($scope.customer == null || $scope.customer.signupDate == null) { 
	    return false; 
	} else { 
	    return true; 
	}
    };

    // Used to hide/show action message / NOT USING data-dismiss because it removes the whole div
    $('.close').click(function() {
	$('.alert').hide();
    })

    function loadCustomerById(id, cb) {
	if (isNaN(id)) { 
	    // Check if the user previded a number
	    $("#action-message").css('display','block');
            $("#action-message").removeClass("alert-success").addClass("alert-error");
	    $("#alert-block-inner").html("<b>Warning!</b> - ID must be a number");
	    return false;
	} else { 
            var u = utils.url('/crm/customer/' + id);
            utils.get( u, {}, cb);
	}
    }

    $scope.lookupCustomer = function () {
        loadCustomerById($scope.id, function (c) {
            $scope.$apply(function () {
                $scope.customer = c;
            });
            if (c==null) { 
		$("#action-message").css('display','block');
                $("#action-message").removeClass("alert-success").addClass("alert-error");
		$("#alert-block-inner").html("<b>Warning!</b> - Customer ID " + $scope.id + " doesn't exist");
	    }
        });
    };

    $scope.save = function () {
        var id = $scope.id;
        if (id == undefined && $scope.customer.signupDate == undefined) {             
            var u = utils.url('/crm/customer/new');
	} else { 
            var u = utils.url('/crm/customer/' + id);
	}
        var data = JSON.stringify($scope.customer);
	// Only post if the data is defined 
        if (data == undefined || data == "null" || $scope.customer.firstName == undefined || $scope.customer.lastName == undefined) { 
	    return false;
	} else { 
	    utils.post(u, data, function(a){
		$("#action-message").css('display','block');
                $("#action-message").removeClass("alert-error").addClass("alert-success");
		if ($scope.customer.signupDate == undefined) { 
		    // New user creation 
		    $("#alert-block-inner").html("<b>Success</b> - Created new customer " + $scope.customer.firstName + " " + $scope.customer.lastName);
		} else { 
		    $("#alert-block-inner").html("<b>Success</b> - Customer ID " + $scope.id + " updated!");
		}
            });
	}
    };

    $scope.trash = function () {
        $scope.id = null;
        $scope.customer = null;
    };
}

