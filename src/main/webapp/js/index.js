var i = 6; //存放已经加载新闻的数值
//初始化
var b = true; //存放是否还有数据未刷新
getdata(i);
hello();
gettop();
getyule(i);
getyaowen(i);
getnewera(i);
getduanzi(i);
gettiyu(i);
getfeiyan(i);
guanzhuneirong(i);
denglu();
btncode();
//主页面和子页面的切换
//初始化单页view
function hello() {
	var viewApi = mui('#app').view({
		defaultPage: '#main'
	});
	//初始化单页的区域滚动
	mui('.mui-scroll-wrapper').scroll();
	var view = viewApi.view;
	(function ($) {
		var oldBack = $.back;
		$.back = function () {
			if (viewApi.canBack()) {
				viewApi.back();
			} else {
				oldBack();
			}
		};
		view.addEventListener('pageBeforeShow', function (e) { });
		view.addEventListener('pageShow', function (e) { });
		view.addEventListener('pageBeforeBack', function (e) { });
		view.addEventListener('pageBack', function (e) { });
	})(mui);
}
//下拉和上滑
function chushi() {
	mui("#scroll2").pullRefresh({

		down: {
			height: 20, //可选,默认50.触发下拉刷新拖动距离,
			auto: false, //可选,默认false.首次加载自动下拉刷新一次
			contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
			contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
			contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
			callback: function () {
				getdata(i, b);
				mui.toast("更新了数据");
				this.endPulldownToRefresh(true)

			} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
		},
		up: {
			height: 20, //可选.默认50.触发上拉加载拖动距离
			auto: false, //可选,默认false.自动上拉加载一次
			contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
			contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
			callback: function () { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
				getdata(i + 6, b)
				if (b) {
					mui.toast("加载几条数据");
					this.endPullupToRefresh(false);
				} else {
					this.endPullupToRefresh(true);
				}

			}
		}

	});
}

function yule() {
	mui("#scroll4").pullRefresh({
		down: {
			height: 20, //可选,默认50.触发下拉刷新拖动距离,
			auto: false, //可选,默认false.首次加载自动下拉刷新一次
			contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
			contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
			contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
			callback: function () {
				getyule(i, b)
				mui.toast("更新了数据");
				this.endPulldownToRefresh(true)

			} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
		},
		up: {
			height: 20, //可选.默认50.触发上拉加载拖动距离
			auto: false, //可选,默认false.自动上拉加载一次
			contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
			contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
			callback: function () { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
				getyule(i + 6, b)
				if (b) {
					mui.toast("加载几条数据");
					this.endPullupToRefresh(false);
				} else {
					this.endPullupToRefresh(true);
				}

			}
		}

	});
}

function yaowen() {
	mui("#scroll5").pullRefresh({
		down: {
			height: 20, //可选,默认50.触发下拉刷新拖动距离,
			auto: false, //可选,默认false.首次加载自动下拉刷新一次
			contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
			contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
			contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
			callback: function () {
				getyaowen(i, b)
				mui.toast("更新了数据");
				this.endPulldownToRefresh(true)

			} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
		},
		up: {
			height: 20, //可选.默认50.触发上拉加载拖动距离
			auto: false, //可选,默认false.自动上拉加载一次
			contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
			contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
			callback: function () { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
				getyaowen(i + 6, b)
				if (b) {
					mui.toast("加载几条数据");
					this.endPullupToRefresh(false);
				} else {
					this.endPullupToRefresh(true);
				}

			}
		}

	});
}

function newera() {
	mui("#scroll6").pullRefresh({
		down: {
			height: 20, //可选,默认50.触发下拉刷新拖动距离,
			auto: false, //可选,默认false.首次加载自动下拉刷新一次
			contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
			contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
			contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
			callback: function () {
				getnewera(i, b)
				mui.toast("更新了数据");
				this.endPulldownToRefresh(true)

			} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
		},
		up: {
			height: 20, //可选.默认50.触发上拉加载拖动距离
			auto: false, //可选,默认false.自动上拉加载一次
			contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
			contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
			callback: function () { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
				getnewera(i + 6, b)
				if (b) {
					mui.toast("加载几条数据");
					this.endPullupToRefresh(false);
				} else {
					this.endPullupToRefresh(true);
				}

			}
		}

	});
}

function duanzi() {
	mui("#scroll7").pullRefresh({
		down: {
			height: 20, //可选,默认50.触发下拉刷新拖动距离,
			auto: false, //可选,默认false.首次加载自动下拉刷新一次
			contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
			contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
			contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
			callback: function () {
				getduanzi(i, b)
				mui.toast("更新了数据");
				this.endPulldownToRefresh(true)

			} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
		},
		up: {
			height: 20, //可选.默认50.触发上拉加载拖动距离
			auto: false, //可选,默认false.自动上拉加载一次
			contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
			contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
			callback: function () { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
				getnewera(i + 6, b)
				if (b) {
					mui.toast("加载几条数据");
					this.endPullupToRefresh(false);
				} else {
					this.endPullupToRefresh(true);
				}

			}
		}

	});
};

function tiyu() {
	mui("#scroll8").pullRefresh({

		down: {
			height: 20, //可选,默认50.触发下拉刷新拖动距离,
			auto: false, //可选,默认false.首次加载自动下拉刷新一次
			contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
			contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
			contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
			callback: function () {
				gettiyu(i, b);
				mui.toast("更新了数据");
				this.endPulldownToRefresh(true)

			} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
		},
		up: {
			height: 20, //可选.默认50.触发上拉加载拖动距离
			auto: false, //可选,默认false.自动上拉加载一次
			contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
			contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
			callback: function () { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
				getdata(i + 6, b)
				if (b) {
					mui.toast("加载几条数据");
					this.endPullupToRefresh(false);
				} else {
					this.endPullupToRefresh(true);
				}

			}
		}

	});
}

function feiyan() {
	mui("#scroll3").pullRefresh({

		down: {
			height: 20, //可选,默认50.触发下拉刷新拖动距离,
			auto: false, //可选,默认false.首次加载自动下拉刷新一次
			contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
			contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
			contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
			callback: function () {
				getfeiyan(i, b);
				mui.toast("更新了数据");
				this.endPulldownToRefresh(true)

			} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
		},
		up: {
			height: 20, //可选.默认50.触发上拉加载拖动距离
			auto: false, //可选,默认false.自动上拉加载一次
			contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
			contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
			callback: function () { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
				getfeiyan(i + 6, b)
				if (b) {
					mui.toast("加载几条数据");
					this.endPullupToRefresh(false);
				} else {
					this.endPullupToRefresh(true);
				}

			}
		}

	});
}
//ajax初始化数据
function gettop() {
	mui.get('http://localhost:8080/newsapp/topNav/findbyBottomNavId/1', {
		category: 'list'
	}, function (data) {
		var str = "";
		mui.each(data.data, function (index) {
			if (index >= 8) {

			} else {
				if (index != 1) {
					str += "<a class=\"mui-control-item\" href=#item" + data.data[index].id + "mobile>" + data.data[index].name + "</a>";
				} else {
					str += "<a class=\"mui-control-item mui-active\" href=#item" + data.data[index].id + "mobile>" + data.data[index].name + "</a>";
				}

			}

		})
		$(".mui-slider-indicator").html(str);
	}, 'json');
}

function getdata(nu, b) {

	mui.get("http://localhost:8080/newsapp/headline/list", {
		category: 'list'
	}, function (data) {
		var str = "";
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].title == null) {
					b = false;
				} else {
					str += "<a href=\"#son\"><div class=\"mui-card\" id=" + data.data[index].id + "><div class=\"mui-card-header\"><div class=\"index_cardtitle\"><h4>" + data.data[index].title + "</h4><p><span>" + data.data[index].author + "</span></p></div><div class=\"index_listimg\"><img src=" + data.data[index].images + "></div></div></div></a>";
				}
			}
		});
		//添加事件
		mui('#main').on('tap', '.mui-card', function () {
			var id = $(this).attr("id") - 1;
			console.log(id)
			$("#xiang").html("<h3>" + data.data[id].title + "</h3><p>" + data.data[id].author + "</p><p><span>" + data.data[id].updateTime + "</span></p><p>" + data.data[id].content + "<p><img src=" + data.data[id].images + ">");
		})
		$("#new_list").html(str);
	}, 'json');
	chushi();
};

function getyule(nu, b) {
	mui.get("http://localhost:8080/newsapp/pastime/list", {
		category: 'list'
	}, function (data) {
		var str = "";
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].title == null) {
					b = false;
				} else {
					if (data.data[index].id == 1) {
						str += "<a href=\"#yule\"><div class='mui-card'>" +
							"<div class='mui-card-header'>" +
							"<div class='mui-slider'>" +
							"<div class='mui-slider-group'>" +
							"<div class='mui-slider-item'>" +
							"<img src=" + data.data[index].images + " />" +
							"</div>" +
							"<div class='mui-h4'>" + data.data[index].title + "</div>" +
							"</div></div></div></div></a>"
					} else {
						str += "<a href=\"#yule\"><div class=\"mui-card\" id=" + data.data[index].id + "><div class=\"mui-card-header\"><div class=\"index_cardtitle\"><h4>" + data.data[index].title + "</h4><p><span>" + data.data[index].author + "</span></p></div><div class=\"index_listimg\"><img src=" + data.data[index].images + "></div></div></div></a>";

					}
				}
			}
		});
		//添加事件
		mui('#main').on('tap', '.mui-card', function () {
			var id = $(this).attr("id") - 1;
			console.log(id)
			$("#yl").html("<h3>" + data.data[id].title + "</h3><p>" + data.data[id].author + "</p><p><span>" + data.data[id].updateTime + "</span></p><p>" + data.data[id].content + "<p><img src=" + data.data[id].images + ">");
		})
		$("#new_list_yule").html(str);
	}, 'json');
	yule();
};

function getyaowen(nu, b) {
	mui.get("http://localhost:8080/newsapp/choiceness/list", {
		category: 'list'
	}, function (data) {
		var str = "";
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].title == null) {
					b = false;
				} else {
					if (data.data[index].id == 1) {
						str += "<a href=\"#yaowen\"><div class='mui-card'>" +
							"<div class='mui-card-header'>" +
							"<div class='mui-slider'>" +
							"<div class='mui-slider-group'>" +
							"<div class='mui-slider-item'>" +
							"<img src=" + data.data[index].images + " />" +
							"</div>" +
							"<div class='mui-h4'>" + data.data[index].title + "</div>" +
							"</div></div></div></div></a>"
					} else {
						str += "<a href=\"#yaowen\"><div class=\"mui-card\" id=" + data.data[index].id + "><div class=\"mui-card-header\"><div class=\"index_cardtitle\"><h4>" + data.data[index].title + "</h4><p><span>" + data.data[index].author + "</span></p></div><div class=\"index_listimg\"><img src=" + data.data[index].images + "></div></div></div></a>";

					}
				}
			}
		});
		//添加事件
		mui('#main').on('tap', '.mui-card', function () {
			var id = $(this).attr("id") - 1;
			console.log(id)
			$("#yw").html("<h3>" + data.data[id].title + "</h3><p>" + data.data[id].author + "</p><p><span>" + data.data[id].updateTime + "</span></p><p>" + data.data[id].content + "<p><img src=" + data.data[id].images + ">");
		})
		$("#new_list_yaowen").html(str);
	}, 'json');
	yaowen();
};

function getnewera(nu, b) {
	mui.get("http://localhost:8080/newsapp/newTime/list", {
		category: 'list'
	}, function (data) {
		var str = "";
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].title == null) {
					b = false;
				} else {
					if (data.data[index].id == 1) {
						str += "<a href=\"#newera\"><div class='mui-card'>" +
							"<div class='mui-card-header'>" +
							"<div class='mui-slider'>" +
							"<div class='mui-slider-group'>" +
							"<div class='mui-slider-item'>" +
							"<img src=" + data.data[index].images + " />" +
							"</div>" +
							"<div class='mui-h4'>" + data.data[index].title + "</div>" +
							"</div></div></div></div></a>"
					} else {
						str += "<a href=\"#newera\"><div class=\"mui-card\" id=" + data.data[index].id + "><div class=\"mui-card-header\"><div class=\"index_cardtitle\"><h4>" + data.data[index].title + "</h4><p><span>" + data.data[index].author + "</span></p></div><div class=\"index_listimg\"><img src=" + data.data[index].images + "></div></div></div></a>";

					}
				}
			}
		});
		//添加事件
		mui('#main').on('tap', '.mui-card', function () {
			var id = $(this).attr("id") - 1;
			console.log(id)
			$("#era").html("<h3>" + data.data[id].title + "</h3><p>" + data.data[id].author + "</p><p><span>" + data.data[id].updateTime + "</span></p><p>" + data.data[id].content + "<p><img src=" + data.data[id].images + ">");
		})
		$("#new_list_newera").html(str);
	}, 'json');
	newera();
};

function getduanzi(nu, b) {
	mui.get("http://localhost:8080/newsapp/joke/list", {
		category: 'list'
	}, function (data) {
		var str = "";
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].title == null) {
					b = false;
				} else {
					str += "<a href=\"#duanzi\"><div class='mui-card'><div class='mui-card-header'><div class='mui-slider'>" +
						"<p class='text'>" + data.data[index].content + "</p>" +
						"<div class='mui-row' style='background: white;'>" +
						"<div class='mui-col-sm-4' style='padding-right: 5%;'>" +
						"<span class='mui-icon iconfont icon-kaixin1'></span>" +
						"<span class='mui-h5'>" + data.data[index].laugh + "</span>" +
						"</div>" +
						"<div class='mui-col-sm-4' style='padding-right: 5%;'>" +
						"<span class='mui-icon iconfont icon-weixiao'></span>" +
						"<span class='mui-h5'>" + data.data[index].enjoy + "</span>" +
						"</div>" +
						"<div class='mui-col-sm-4' style='padding-right: 5%;'>" +
						"<span class='mui-icon iconfont icon-biaoqing-tushetou-'></span>" +
						"<span class='mui-h5'>" + data.data[index].bored + "</span>" +
						"</div></div></div></div></div></a>"
				}
			}
		});
		//添加事件
		mui('#main').on('tap', '.mui-card', function () {
			var id = $(this).attr("id") - 1;
			console.log(id)
			$("#dz").html("<h3>" + data.data[id].title + "</h3><p>" + data.data[id].author + "</p><p><span>" + data.data[id].updateTime + "</span></p><p>" + data.data[id].content + "<p><img src=" + data.data[id].images + ">");
		})
		$("#new_list_duanzi").html(str);
	}, 'json');
	duanzi();
};

function gettiyu(nu, b) {
	mui.get("http://localhost:8080/newsapp/sports/list", {
		category: 'list'
	}, function (data) {
		var str = "";
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].title == null) {
					b = false;
				} else {
					if (data.data[index].id == 1) {
						str += "<a href=\"#tiyu\"><div class='mui-card'>" +
							"<div class='mui-card-header'>" +
							"<div class='mui-slider'>" +
							"<div class='mui-slider-group'>" +
							"<div class='mui-slider-item'>" +
							"<img src=" + data.data[index].images + " />" +
							"</div>" +
							"<div class='mui-h4'>" + data.data[index].title + "</div>" +
							"</div></div></div></div></a>"
					} else {
						str += "<a href=\"#tiyu\"><div class=\"mui-card\" id=" + data.data[index].id + "><div class=\"mui-card-header\"><div class=\"index_cardtitle\"><h4>" + data.data[index].title + "</h4><p><span>" + data.data[index].author + "</span></p></div><div class=\"index_listimg\"><img src=" + data.data[index].images + "></div></div></div></a>";

					}
				}
			}
		});
		//添加事件
		mui('#main').on('tap', '.mui-card', function () {
			var id = $(this).attr("id") - 1;
			console.log(id)
			$("#ty").html("<h3>" + data.data[id].title + "</h3><p>" + data.data[id].author + "</p><p><span>" + data.data[id].updateTime + "</span></p><p>" + data.data[id].content + "<p><img src=" + data.data[id].images + ">");
		})
		$("#new_list_tiyu").html(str);
	}, 'json');
	tiyu();
};

function getfeiyan(nu, b) {
	mui.get("http://localhost:8080/newsapp/epidemic/special", {
		category: 'list'
	}, function (data) {
		var str1 = "";
		mui.each(data.data, function (index) {

			if (data.data[index].title == null) {
				b = false;
			} else {
				str1 += "<a href=\"#feiyan\"><div class='mui-card'>" +
					"<div class='mui-card-header'>" +
					"<div class='mui-slider'>" +
					"<div class='mui-slider-group'>" +
					"<div class='mui-slider-item'>" +
					"<img src=" + data.data[index].imgsrc + " />" +
					"</div>" +
					"<div class='mui-h4'>" + data.data[index].title + "</div>" +
					"</div></div></div></div></a>"

			}

		})
		$("#new_list_feiyan").html(str1);
	}, 'json');
	mui.get("http://localhost:8080/newsapp/epidemic/column", {
		category: 'list'
	}, function (data) {
		var str = '';
		var str2 = "";
		mui.each(data.data, function (index) {

			if (data.data[index].name == null) {
				b = false;
			} else {
				str2 += "<div class='mui-col-sm-3 mui-col-xs-3'>" +
					"<div class='mui-slider-item' style='position: static;padding-left: 35%;'>" +
					"<img src=" + data.data[index].icon + " style='width: 50%;'/>" +
					"</div>" +
					"<div style='text-align: center; padding-bottom: 12%;'>" + data.data[index].name + "</div>" +
					"</div>"

			}

		})
		str = "<div class='mui-card'><div class='mui-card-header'><div class='mui-slider'>" + "<div class='mui-row'>" + str2 + "</div></div></div></div>"
		$("#new_list_feiyan1").html(str);
	}, 'json');
	mui.get("http://localhost:8080/newsapp/epidemic/data", {
		category: 'list'
	}, function (data) {
		var str3 = '';
		var str4 = '';
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].name == null) {
					b = false;
				} else {
					if (data.data[index].id == 1) {
						str4 += "<div class='mui-col-sm-3 mui-col-xs-3' style='text-align: center;'>" +
							"<h3 class='p'>" + data.data[index].name + "</h3>" +
							"<span class='mui-h3  mui-badge-danger mui-badge-inverted'>" + data.data[index].num + "</span>" +
							"<div>" +
							"<h6>较昨日<span class='mui-badge  mui-badge-danger mui-badge-inverted'>" + data.data[index].subNum + "</span></h6></div></div>"

					} else if (data.data[index].id == 2) {
						str4 += "<div class='mui-col-sm-3 mui-col-xs-3' style='text-align: center;'>" +
							"<h3 class='p'>" + data.data[index].name + "</h3>" +
							"<span class='mui-h3  mui-badge-warning mui-badge-inverted'>" + data.data[index].num + "</span>" +
							"<div>" +
							"<h6>较昨日<span class='mui-badge  mui-badge-warning mui-badge-inverted'>" + data.data[index].subNum + "</span></h6></div></div>"

					} else if (data.data[index].id == 3) {
						str4 += "<div class='mui-col-sm-3 mui-col-xs-3' style='text-align: center;'>" +
							"<h3 class='p'>" + data.data[index].name + "</h3>" +
							"<span class='mui-h3   mui-badge-inverted' style='color: #888888;'>" + data.data[index].num + "</span>" +
							"<div>" +
							"<h6>较昨日<span class='mui-badge  mui-badge-inverted' style='color: #888888;'>" + data.data[index].subNum + "</span></h6></div></div>"

					} else if (data.data[index].id == 4) {
						str4 += "<div class='mui-col-sm-3 mui-col-xs-3' style='text-align: center;'>" +
							"<h3 class='p'>" + data.data[index].name + "</h3>" +
							"<span class='mui-h3  mui-badge-success mui-badge-inverted'>" + data.data[index].num + "</span>" +
							"<div>" +
							"<h6>较昨日<span class='mui-badge  mui-badge-success mui-badge-inverted'>" + data.data[index].subNum + "</span></h6></div></div>"

					}

				}
			}
		})
		str3 = "<div class='mui-card'>" +
			"<div class='mui-card-header'>" +
			"<div class='mui-slider'>" +
			"<h3>全国疫情数据（含港澳台）</h3><h6>" + data.data[1].lastUpdateTime + "</h6>" +
			"<div class='mui-row'>" + str4 + "</div></div></div></div>"

		$("#new_list_feiyan2").html(str3);
	}, 'json');
	mui.get("http://localhost:8080/newsapp/epidemic/epidemicNews", {
		category: 'list'
	}, function (data) {
		var str5 = "";
		mui.each(data.data, function (index) {
			if (index >= nu) { } else {
				if (data.data[index].title == null) {
					b = false;
				} else {
					str5 += "<a href=\"#feiyan\"><div class=\"mui-card\" id=" + data.data[index].id + "><div class=\"mui-card-header\"><div class=\"index_cardtitle\"><h4>" + data.data[index].title + "</h4><p><span>" + data.data[index].author + "</span></p></div><div class=\"index_listimg\"><img src=" + data.data[index].images + "></div></div></div></a>";
				}
			}
		});
		//添加事件
		mui('#main').on('tap', '.mui-card', function () {
			var id = $(this).attr("id") - 1;
			console.log(id)
			$("#fy").html("<h3>" + data.data[id].title + "</h3><p>" + data.data[id].author + "</p><p><span>" + data.data[id].updateTime + "</span></p><p>" + data.data[id].content + "<p><img src=" + data.data[id].images + ">");
		})
		$("#new_list_feiyan3").html(str5);
	}, 'json');
	feiyan();
}

function guanzhuneirong(nu, b) {
	mui.get('http://localhost:8080/newsapp/attention/list', {
		category: 'list'
	}, function (data) {
		var str = '';
		var str_1 = '';
		console.log(data.msg);
		console.log(data.data[1].writer[0].avatar)
		if (data.msg == "登录后再关注，第一时间获取最新动态" || data.msg == "你的关注暂无,为您推荐热门内容") {
			str += "<div class='mui-card' style='margin-top: 1%;'>" +
				"<div class='mui-card-header'>" +
				"<div class='mui-slider'>" +
				"<div class='mui-h5' style='text-align: center; padding-top: 5%;'>" + data.msg + "</div>" +
				"<div class='mui-popup-button' style='padding-top: 3%;'>" +
				"<a href='#signin'><button type='button' class='mui-btn mui-btn-danger' id='denglu'>登录</button></a>" +
				"</div></div></div></div>"
			$("#new_list_guanzhu").html(str);
			mui.each(data.data, function (index) {
				if (index >= nu) { } else {
					if (data.data[index].title == null) {
						b = false;
					} else {
						str_1 += "<div class='mui-card' style='margin-top: 1%;'>" +
							"<div class='mui-card-header mui-card-media' style='position: static;'>" +
							"<img src=" + data.data[index].writer[0].avatar + "/ style='width: 37px;'>" +
							"<div class='mui-pull-right'>" +
							"<button type='button' class='mui-btn mui-btn-danger'>关注</button>" +
							"</div>" +
							"<div class='mui-media-body'>" +
							"" + data.data[index].writer[0].author + "" +
							"<p>" + data.data[index].writer[0].updateTime + "</p>" +
							"</div>" +
							"</div>" +
							"<div class='mui-card-content mui-card-content-inner' style='padding-top: 0;padding-bottom: 0;'>" +
							"" + data.data[index].title + "" +
							"<div class='mui-slider'>" +
							"<div class='mui-slider-group'>" +
							"<div class='mui-slider-item'>" +
							"<a href='#'><img src=" + data.data[index].images + " /></a>" +
							"</div>" +
							"</div>" +
							"</div>" +
							"</div>" +
							"<div class='mui-card-footer' style='position: static;'>" +
							"<div class='mui-h5'>跟帖" + data.data[index].commentCount + "</div>" +
							"</div>" +
							"</div>"
					}
				}

			});
			$("#new_list_guanzhu1").html(str_1);
		} else {

		}
	}, 'json');
}

function denglu() {

	mui(".mui-button-row").on("tap", "#inpdenglu", function (event) {
		var check = true;
		mui("#input_example input").each(function () {
			//若当前input为空，则alert提醒 
			if (!this.value || this.value.trim() == "") {
				var label = this.previousElementSibling;
				mui.alert(label.innerText + "不允许为空");
				check = false;
				return false;
			}
		}); //校验通过，继续执行业务逻辑 
		var phone = document.getElementById('phone').value;
		if (!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phone))) {
			mui.alert("手机号格式不正确");
			check = false;
			return false;
		}
		var reqcode = document.getElementById('reqCode').value;
		var code = document.getElementById("verificationCode").innerHTML;
		if (reqcode != code) {
			mui.alert("验证码不正确");
			check = false;
			return false;
		}
		if (check) {
			mui.alert('验证通过!');
			postdenglu(phone, code);
		}
	});
}
function getcode() {
	var phone = document.getElementById('phone').value;
	mui.get('http://localhost:8080/newsapp/user/code/' + phone, 
	{ category: 'list' }, function (data) {

		document.getElementById("verificationCode").innerHTML = data.data;
		console.log("验证码:" + document.getElementById("verificationCode").innerHTML);
	}, 'json'
	);

	
}
function btncode() {
	mui("#divcode").on("tap", "#btncode", function (event) {
		var f = true;
		var phone = document.getElementById('phone').value;
		if (!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phone))) {
			mui.alert("手机号格式不正确");
			f = false;
			return false;
		}
		if (f) {
			getcode();
		}
	});
}
function postdenglu(phone, code) {
	console.log(phone, code);
	mui.post('http://localhost:8080/newsapp/user/login', {
		phone: phone,
		reqCode: code
	}, function (data) {
		console.log(data)
	}, 'json'
	);
	

}
