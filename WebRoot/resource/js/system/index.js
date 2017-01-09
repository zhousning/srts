// JavaScript Document
var navigationItemNumber = 0;
function mouseInNavigationItem(itemNumber) {
	$("#navigationItem" + itemNumber)
			.css("background-image",
					"url(resource/image/system/index_banner_navigation_bg_mousein.png)");
}
function mouseOutNavigationItem(itemNumber) {
	if (navigationItemNumber != itemNumber) {
		$("#navigationItem" + itemNumber).css("background-image", "");
	}
}
function mouseDownNavigationItem(itemNumber) {
	navigationItemNumber = itemNumber;
	$("#navigationItem1").css("background-image", "");
	$("#navigationItem2").css("background-image", "");
	$("#navigationItem3").css("background-image", "");
	$("#navigationItem4").css("background-image", "");
	$("#navigationItem5").css("background-image", "");
	$("#navigationItem6").css("background-image", "");
	$("#navigationItem7").css("background-image", "");
	$("#navigationItem8").css("background-image", "");
	$("#navigationItem" + itemNumber)
			.css("background-image",
					"url(resource/image/system/index_banner_navigation_bg_mousein.png)");
}
//var bannerNumber = 1;
//function autoModifyBanner() {
//	if (bannerNumber == 1) {
//		bannerNumber = 2;
//		$("#index_banner").css("background-image",
//				"url(resource/image/system/index_banner2.jpg)");
//	} else if (bannerNumber == 2) {
//		bannerNumber = 3;
//		$("#index_banner").css("background-image",
//				"url(resource/image/system/index_banner3.jpg)");
//	} else if (bannerNumber == 3) {
//		bannerNumber = 4;
//		$("#index_banner").css("background-image",
//				"url(resource/image/system/index_banner4.jpg)");
//	} else if (bannerNumber == 4) {
//		bannerNumber = 5;
//		$("#index_banner").css("background-image",
//				"url(resource/image/system/index_banner5.jpg)");
//	} else if (bannerNumber == 5) {
//		bannerNumber = 6;
//		$("#index_banner").css("background-image",
//				"url(resource/image/system/index_banner6.jpg)");
//	} else if (bannerNumber == 6) {
//		bannerNumber = 1;
//		$("#index_banner").css("background-image",
//				"url(resource/image/system/index_banner1.jpg)");
//	}
//}
//setInterval(autoModifyBanner, 10000);
var pieChart;pieChart = new Highcharts.Chart( {
								chart : {
									type : 'pie',
									plotBackgroundColor : null,
									backgroundColor : 'rgba(255, 255, 255, 0)',
									plotBackgroundImage : null,
									plotBorderWidth : null,
									plotShadow : false,
									renderTo : 'pieChart',
								},
								colors : [ '#006e6b', '#f7ab00', '#c5002e' ],
								title : {
									text : '安规考核成绩分布情况',
									style: { fontSize: '14px',color:'#000000'}
								},
								credits : {
											enabled : false
										},
								tooltip : {
									pointFormat : '{series.name}: {point.percentage}%',
									percentageDecimals : 1,
									style: {
											fontSize: '10px'
									}
								},
								plotOptions : {
									pie : {
										allowPointSelect : true,
										cursor : 'pointer',
										dataLabels : {
											enabled : false
										},
										showInLegend : true
									}
								},
								series: [{
					                name : '百分比',
					                data: [['优秀率', 40],['达标率', 30],['未达标率', 30]]
					            }]
							});
var columnLineAndPieChart;
columnLineAndPieChart = new Highcharts.Chart( {
						chart : {
							plotBackgroundColor : null,
							backgroundColor : 'rgba(255, 255, 255, 0)',
							plotBackgroundImage : null,
							plotBorderWidth : null,
							plotShadow : false,
							renderTo : 'columnLineAndPieChart'
						},
						credits : {
							enabled : false
						},
						title : {
							text : '安规考核成绩部门分布情况',
							style : {
								fontSize : '14px',
								color : '#000000'
							}
						},
						xAxis : {
							categories : ['吉林供电公司', '安全监察质量部', '运维检修部', '基建部', '营销部']
						},
						yAxis : {
							title : {
								text : '数量（项）'
							}
						},
						tooltip : {
							formatter : function() {
								var s;
								if (this.point.name) { // the pie chart
							s = '' + this.point.name + ': ' + this.y + ' 项';
						} else {
							s = '' + this.x + ': ' + this.y + ' 项';
						}
						return s;
					}
				},
				labels : {
					items : [ {
						html : '成绩比例分布',
						style : {
							left : '15px',
							top : '-10px',
							color : 'black'
						}
					} ]
				},
				series : [ {
					type : 'column',
					name : '优秀',
					data : [3, 2, 1, 3, 4]
				}, {
					type : 'column',
					name : '良好',
					data : [2, 3, 5, 7, 6]
				}, {
					type : 'column',
					name : '中等',
					data : [4, 3, 3, 9, 4]
				}, {
					type : 'spline',
					name : '数量和',
					data : [9, 8, 9, 19, 14],
					marker : {
						lineWidth : 2,
						lineColor : Highcharts.getOptions().colors[3],
						fillColor : 'white'
					}
				}, {
					type : 'pie',
					name : '',
					data : [ {
						name : '优秀',
						y : 13,
						color : Highcharts.getOptions().colors[0]
					// Jane's color
							}, {
								name : '良好',
								y : 23,
								color : Highcharts.getOptions().colors[1]
							// John's color
							}, {
								name : '中等',
								y : 23,
								color : Highcharts.getOptions().colors[2]
							// Joe's color
							} ],
					center : [ 30, 30 ],
					size : 90,
					showInLegend : false,
					dataLabels : {
						enabled : false
					}
				} ]
					});