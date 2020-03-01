var i = 6; //存放已经加载新闻的数值
//初始化
var b=true;//存放是否还有数据未刷新
getdata(i);
hello();
//主页面和子页面的切换
//初始化单页view
function hello(){
var viewApi = mui('#app').view({
	defaultPage: '#main'
});
//初始化单页的区域滚动
mui('.mui-scroll-wrapper').scroll();
var view = viewApi.view;　　
(function($) {　　　　
	var oldBack = $.back;　　　　
	$.back = function() {
		if(viewApi.canBack()) {　　　　　　　　
			viewApi.back();　　　　　　
		} else {　
			oldBack();
		}
	};
	view.addEventListener('pageBeforeShow', function(e) {
		　　　　　　　　
	});　　　　
	view.addEventListener('pageShow', function(e) {
		　　　　　　　　　　
	});　　　　
	view.addEventListener('pageBeforeBack', function(e) {
	　　　　　　　　
	});　　　　
	view.addEventListener('pageBack', function(e) {
	　　　　　　　　　
	});　　
})(mui);	
}
//下拉和上滑
function chushi() {
	mui.init({
		pullRefresh: {
			container: "#scroll2", //下拉刷新容器标识，querySelector能定位的css选择器均可，比如：id、.class等
			down: {
				height: 20, //可选,默认50.触发下拉刷新拖动距离,
				auto: false, //可选,默认false.首次加载自动下拉刷新一次
				contentdown: "下拉可以刷新", //可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
				contentover: "释放立即刷新", //可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
				contentrefresh: "正在刷新...", //可选，正在刷新状态时，下拉刷新控件上显示的标题内容
				callback: function() {
					getdata(i,b);
					mui.toast("更新了数据");
					this.endPulldownToRefresh(true)

				} //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
			},
			up: {
				height: 20, //可选.默认50.触发上拉加载拖动距离
				auto: false, //可选,默认false.自动上拉加载一次
				contentrefresh: "正在加载...", //可选，正在加载状态时，上拉加载控件上显示的标题内容
				contentnomore: '没有更多数据了', //可选，请求完毕若没有更多数据时显示的提醒内容；
				callback: function() { //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
					getdata(i+6,b)
					if (b) {
						mui.toast("加载几条数据");
						this.endPullupToRefresh(false);	
					}else{
						this.endPullupToRefresh(true);	
					}



				}
			}
		}
	});
}
//ajax初始化数据
function getdata(nu,b) {
	mui.get('http://122.51.252.120:8080/newsapp/topNav/findbyBottomNavId/1', {
		category: 'list'
	}, function(data) {
		var str = "";
		mui.each(data.data, function(index) {
			if(index >= 6) {
				
			} else {
				if(index != 1) {
					str += "<a class=\"mui-control-item\" href=#item" + data.data[index].id + "mobile>" + data.data[index].name + "</a>";
				} else {
					str += "<a class=\"mui-control-item mui-active\" href=#item" + data.data[index].id + "mobile>" + data.data[index].name + "</a>";
				}

			}

		})
		$(".mui-slider-indicator").html(str);
	}, 'json');
	mui.get("http://122.51.252.120:8080/newsapp/news/findAll", {
		category: 'list'
	}, function(data) {
		var str = "";
		mui.each(data.data, function(index) {
			if(index >= nu) {} else {
				if (data.data[index].title==null) {
					b=false;
				}else{
				str += "<a href=\"#son\"><div class=\"mui-card\" id=" + data.data[index].id + "><div class=\"mui-card-header\"><div class=\"index_cardtitle\"><h4>" + data.data[index].title + "</h4><p><span>" + data.data[index].author + "</span></p></div><div class=\"index_listimg\"><img src=" + data.data[index].images + "></div></div></div></a>";					
				}
			}
		});
		//添加事件
		mui('#main').on('tap','.mui-card',function(){
			var id=$(this).attr("id")-1;
			console.log(id)
		  $("#xiang").html("<h3>"+data.data[id].title+"</h3><p>"+data.data[id].author+"</p><p><span>"+data.data[id].updateTime+"</span></p><p>"+data.data[id].content+"<p><img src="+data.data[id].images+">");
		}) 
		$("#new_list").html(str);
	}, 'json');
	chushi();
};