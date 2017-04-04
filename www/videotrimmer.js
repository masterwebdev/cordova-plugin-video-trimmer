/*global cordova, module*/

module.exports = {
    trim: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "VideoTrimmer", "trim", [name]);
    }
};
