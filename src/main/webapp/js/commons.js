var util = function() {
	this.sy = function() {
		var curWwwPath = window.document.location.href;
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		var localhostPaht = curWwwPath.substring(0, pos);
		var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		return (localhostPaht + projectName);
	};

	this.yyyy_MM_dd = function(t) {
		var date = t == undefined ? new Date() : t;
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		if (month >= 1 && month <= 9) {
			month = "0" + month;
		}
		if (day >= 0 && day <= 9) {
			day = "0" + day;
		}
		return year + "-" + month + "-" + day;
	};

	this.yyyyMMdd = function(t) {
		var date = t == undefined ? new Date() : t;
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		if (month >= 1 && month <= 9) {
			month = "0" + month;
		}
		if (day >= 0 && day <= 9) {
			day = "0" + day;
		}
		return year + month + day;
	};

	this.HH = function() {
		var date = new Date();
		return date.getHours();
	};

	this.mm = function() {
		var date = new Date();
		return date.getMinutes();
	};

	// this.isMobile = function() {
	// return
	// /(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge
	// |maemo|midp|mmp|netfront|opera m(ob|in)i|palm(
	// os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows
	// (ce|phone)|xda|xiino/i.test(navigator.userAgent) ||
	// /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a
	// wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r
	// |s
	// )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1
	// u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp(
	// i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac(
	// |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt(
	// |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg(
	// g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-|
	// |o|v)|zz)|mt(50|p1|v
	// )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v
	// )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-|
	// )|webc|whit|wi(g
	// |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,
	// 4));
	// }

	this.toFixed = function(num, cent, isThousand) {
		// return d.toFixed(n);
		num = num.toString().replace(/\$|\,/g, '');

		// 检查传入数值为数值类型
		if (isNaN(num))
			num = "0";

		// 获取符号(正/负数)
		sign = (num == (num = Math.abs(num)));

		num = Math.floor(num * Math.pow(10, cent) + 0.50000000001); // 把指定的小数位先转换成整数.多余的小数位四舍五入
		cents = num % Math.pow(10, cent); // 求出小数位数值
		num = Math.floor(num / Math.pow(10, cent)).toString(); // 求出整数位数值
		cents = cents.toString(); // 把小数位转换成字符串,以便求小数位长度

		// 补足小数位到指定的位数
		while (cents.length < cent)
			cents = "0" + cents;

		if (isThousand == undefined || isThousand) {
			// 对整数部分进行千分位格式化.
			for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
				num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
		}

		if (cent > 0)
			return (((sign) ? '' : '-') + num + '.' + cents);
		else
			return (((sign) ? '' : '-') + num);
	};

	this.toFixed2 = function(num) {
		return this.toFixed(num, 2, true);
	};

	this.toFixed0 = function(num) {
		return this.toFixed(num, 0, true);
	};

	this.data_service = "http://10.127.133.91:8080/data";
	this.data_service_bak = "";

	this.data_service_getconfig = this.data_service_bak + "/dataservice/getconfig.do?";
	this.data_service_getconfig_bak = this.data_service + "/dataservice/getconfig.do?";

};

var $util = new util();
