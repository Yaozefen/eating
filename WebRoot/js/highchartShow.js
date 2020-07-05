/**
 *
 * Active Charts using Highcharts demonstration
 *
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 * 
 * Copyright 2012, Script Tutorials
 * http://www.script-tutorials.com/
 */

// Change Chart type function
function ChangeChartType(chart, series, newType) {
    newType = newType.toLowerCase();
    for (var i = 0; i < series.length; i++) {
        var srs = series[0];
        try {
            srs.chart.addSeries({
                type: newType,
                stack: srs.stack,
                yaxis: srs.yaxis,
                name: srs.name,
                color: srs.color,
                data: srs.options.data
            },
            false);
            series[0].remove();
        } catch (e) {
        }
    }
}

// Two charts definition
var chart1;

// Once DOM (document) is finished loading
$(document).ready(function() {
    // First chart initialization
    chart1 = new Highcharts.Chart({
     chart: {
        renderTo: 'chart_1',
        type: 'column',
        height: 350,
     },
     title: {
        text: 'Tools developers plans to use to make html5 games (in %)'
     },
     xAxis: {
        categories: [$('.value1').eq(0).val(),$('.value1').eq(1).val(),$('.value1').eq(2).val(), $('.value1').eq(3).val(), $('.value1').eq(4).val(), $('.value1').eq(5).val(), $('.value1').eq(6).val(), $('.value1').eq(7).val(), $('.value1').eq(8).val(),$('.value1').eq(9).val()]
     },
     yAxis: {
        title: {
           text: 'Interviewed'
        }
     },
     series: [{
        name: 'TURNOVER',
        data: [parseInt($('.value2').eq(0).val()),parseInt($('.value2').eq(1).val()),parseInt($('.value2').eq(2).val()),parseInt($('.value2').eq(3).val()),parseInt($('.value2').eq(4).val()),parseInt($('.value2').eq(5).val()),parseInt($('.value2').eq(6).val()),parseInt($('.value2').eq(7).val()),parseInt($('.value2').eq(8).val()),parseInt($('.value2').eq(9).val())]
     }]
    });
   

    // Switchers (of the Chart1 type) - onclick handler
    $('.switcher').click(function () {  
        var newType = $(this).attr('id');
        ChangeChartType(chart1, chart1.series, newType);
    });
});