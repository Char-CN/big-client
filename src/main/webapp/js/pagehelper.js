var PageHelper = function(id) {
	this.id = id;
	this.init = function(currentPage, pageSize, total, findByPage) {
		var pagination = $('#' + this.id);
		pagination.empty();
		var showSize = 9;
		pagination.empty();
		var li_first = $('<li><span>首页</span></li>');
		li_first.click(function() {
			findByPage(1);
		});
		pagination.append(li_first);

		var totalPage = Math.ceil(total / pageSize);
		var start = 0;
		var end = 0;

		if (totalPage < showSize) {
			start = 1;
			end = totalPage;
		} else if (currentPage >= totalPage - parseInt(showSize/2)) {
			start = totalPage - showSize + 1;
			end = totalPage;
		} else if (currentPage <= parseInt(showSize/2)){
			start = 1;
			end = showSize;
		} else {
			start = currentPage - parseInt(showSize/2);
			end = currentPage + parseInt(showSize/2);
		}
		for (var i = start; i <= end; i++) {
			var cls = currentPage == i ? "active" : "";
			var li = $('<li class="' + cls + '"><span>' + i + '</span></li>');
			li.click(function() {
				findByPage($(this).text());
			});
			pagination.append(li);
		}
		var li_end = $('<li><span>尾页</span></li>');
		li_end.click(function() {
			findByPage(totalPage);
		});
		pagination.append(li_end);
		pagination.append('<li><span>共' + total + '条数据</span></li>');
	};
};
