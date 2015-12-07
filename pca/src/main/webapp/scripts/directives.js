'use strict';

angular.module('pcaApp')
    .directive('activeMenu', ['$translate', '$locale', 'tmhDynamicLocale', function($translate, $locale, tmhDynamicLocale) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs, controller) {
                var language = attrs.activeMenu;

                scope.$watch(function() {
                    return $translate.use();
                }, function(selectedLanguage) {
                    if (language === selectedLanguage) {
                        tmhDynamicLocale.set(language);
                        element.addClass('active');
                    } else {
                        element.removeClass('active');
                    }
                });
            }
        };
    }])
    .directive('activeLink', ['$location', function(location) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs, controller) {
                var clazz = attrs.activeLink;
                var path = attrs.href;
                path = path.substring(1); //hack because path does bot return including hashbang
                scope.location = location;
                scope.$watch('location.path()', function(newPath) {
                    if (path === newPath) {
                        element.addClass(clazz);
                    } else {
                        element.removeClass(clazz);
                    }
                });
            }
        };
    }])
.directive('passwordStrengthBar', function() {
        return {
            replace: true,
            restrict: 'E',
            template: '<div id="strength">' +
                      '<small translate="global.messages.validate.newpassword.strength">Password strength:</small>' +
                      '<ul id="strengthBar">' +
                        '<li class="point"></li><li class="point"></li><li class="point"></li><li class="point"></li><li class="point"></li>' +
                      '</ul>' +
                    '</div>',
            link: function(scope, iElement, attr) {
                var strength = {
                    colors: ['#F00', '#F90', '#FF0', '#9F0', '#0F0'],
                    mesureStrength: function (p) {

                        var _force = 0;
                        var _regex = /[$-/:-?{-~!"^_`\[\]]/g; // "
                                              
                        var _lowerLetters = /[a-z]+/.test(p);                    
                        var _upperLetters = /[A-Z]+/.test(p);
                        var _numbers = /[0-9]+/.test(p);
                        var _symbols = _regex.test(p);
                                              
                        var _flags = [_lowerLetters, _upperLetters, _numbers, _symbols];                    
                        var _passedMatches = $.grep(_flags, function (el) { return el === true; }).length;                                          
                        
                        _force += 2 * p.length + ((p.length >= 10) ? 1 : 0);
                        _force += _passedMatches * 10;
                            
                        // penality (short password)
                        _force = (p.length <= 6) ? Math.min(_force, 10) : _force;                                      
                        
                        // penality (poor variety of characters)
                        _force = (_passedMatches == 1) ? Math.min(_force, 10) : _force;
                        _force = (_passedMatches == 2) ? Math.min(_force, 20) : _force;
                        _force = (_passedMatches == 3) ? Math.min(_force, 40) : _force;
                        
                        return _force;

                    },
                    getColor: function (s) {

                        var idx = 0;
                        if (s <= 10) { idx = 0; }
                        else if (s <= 20) { idx = 1; }
                        else if (s <= 30) { idx = 2; }
                        else if (s <= 40) { idx = 3; }
                        else { idx = 4; }

                        return { idx: idx + 1, col: this.colors[idx] };
                    }
                };  
                scope.$watch(attr.passwordToCheck, function(password) {
                    if (password) {
                        var c = strength.getColor(strength.mesureStrength(password));
                        iElement.removeClass('ng-hide');
                        iElement.find('ul').children('li')
                            .css({ "background": "#DDD" })
                            .slice(0, c.idx)
                            .css({ "background": c.col });
                    }
                });
            }
        }
    }).directive(
			'confirmClick',
			[
					'$q',
					'dialogModal',
					'$translate',
					function($q, dialogModal, $translate) {
						return {
							link : function(scope, element, attrs) {
								// ngClick won't wait for our modal
								// confirmation window to resolve,
								// so we will grab the other values in the
								// ngClick attribute, which
								// will continue after the modal resolves.
								// modify the confirmClick() action so we
								// don't perform it again
								// looks for either confirmClick() or
								// confirmClick('are you sure?')
								var ngClick = attrs.ngClick.replace(
										'confirmClick()', 'true').replace(
										'confirmClick(',
										'confirmClick(true,');

								// setup a confirmation action on the scope
								scope.confirmClick = function(msg) {
									// if the msg was set to true, then
									// return it (this is a workaround to
									// make our dialog work)
									if (msg === true) {
										return true;
									}
									// msg can be passed directly to
									// confirmClick('are you sure?') in
									// ng-click
									// or through the confirm-click
									// attribute on the <a
									// confirm-click="Are you sure?"></a>
									msg = msg
											|| attrs.confirmClick
											|| $translate
													.instant('users.messages.confirmMessage');
									// open a dialog modal, and then
									// continue ngClick actions if it's
									// confirmed
									dialogModal(msg).result
											.then(function() {
												scope.$eval(ngClick);
											});
									// return false to stop the current
									// ng-click flow and wait for our modal
									// answer
									return false;
								};
							}
						}
					} ])

	/*
	 * Open a modal confirmation dialog window with the UI Bootstrap Modal
	 * service. This is a basic modal that can display a message with okay
	 * or cancel buttons. It returns a promise that is resolved or rejected
	 * based on okay/cancel clicks. The following settings can be passed:
	 * 
	 * message the message to pass to the modal body title (optional) title
	 * for modal window okButton text for OK button. set false to not
	 * include button cancelButton text for Cancel button. ste false to not
	 * include button
	 * 
	 */
	.service(
			'dialogModal',
			[
					'$modal',
					function($modal) {
						return function(message, title, okButton,
								cancelButton) {
							// setup default values for buttons
							// if a button value is set to false, then that
							// button won't be included
							okButton = okButton === false ? false
									: (okButton || 'Confirm');
							cancelButton = cancelButton === false ? false
									: (cancelButton || 'Cancel');

							// setup the Controller to watch the click
							var ModalInstanceCtrl = function($scope,
									$modalInstance, settings) {
								// add settings to scope
								angular.extend($scope, settings);
								// ok button clicked
								$scope.ok = function() {
									$modalInstance.close(true);
								};
								// cancel button clicked
								$scope.cancel = function() {
									$modalInstance.dismiss('cancel');
								};
							};

							// open modal and return the instance (which
							// will resolve the promise on ok/cancel clicks)
							var modalInstance = $modal
									.open({
										template : '<div class="my-dialog-modal">\
											<div class="modal-header" ng-show="modalTitle"> \
                <h3 class="modal-title">{{modalTitle}}</h3> \
            </div> \
            <div class="modal-body"><h4>{{modalBody}}</h4></div> \
            <div class="modal-footer"> \
                <button class="btn btn-primary" ng-click="ok()" ng-show="okButton">{{okButton}}</button> \
                <button class="btn btn-default" ng-click="cancel()" ng-show="cancelButton">{{cancelButton}}</button> \
            </div> \
        </div>',
										controller : ModalInstanceCtrl,
										windowClass: 'my-dialog',
										resolve : {
											settings : function() {
												return {
													modalTitle : title,
													modalBody : message,
													okButton : okButton,
													cancelButton : cancelButton
												};
											}
										}
									});
							// return the modal instance
							return modalInstance;
						}
					} ]).directive('toggle', ['$translate', function ($translate) {
				        return {
				            restrict: 'A',
				            link: function (scope, element, attrs) {
				                if (attrs.toggle == "tooltip") {
				                    var t = $translate.instant(attrs.title); 
				                    $(element).attr("title", t);
				                    $(element).tooltip();
				                }
				                if (attrs.toggle == "popover") {
				                    var t = $translate.instant(attrs.content);
				                    $(element).attr("data-content", t);
				                    $(element).popover();
				                }
				            }
				        };
				    }]);