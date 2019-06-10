package com.guoshi.module_home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guoshi.baselib.route.ModuleHomeUtlis;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.guoshi.baselib.utils.StatusBarUtil;
import com.guoshi.baselib.view.LineChartMarkView;
import com.guoshi.module_home.databinding.ActivityHomeTestBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/8
 * 文件描述：图标测试类
 */
@Route(path = ModuleHomeUtlis.test)
public class HomeTestActivity extends AppCompatActivity {
//    private ActivityHomeTestBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_test);
        StatusBarUtil.setStatusBarLightMode(this);
//        binding=DataBindingUtil.setContentView(this,R.layout.activity_home_test);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.framelayouthome,new HomeFragment())
                .commit();
//        //简单折线图
//        initlineChart();
//        //简单柱状图
//        initBarChart();
//        //简单饼图
//        initPieChart();
//        //简单雷达
//        initRadarChart();
    }
//    private List<String> Xdata=new ArrayList<>();
//    private List<Entry> Ydata=new ArrayList<>();
//    private List<Entry> Ydata2=new ArrayList<>();
//    private void initlineChart(){
//        binding.lineChart.setScaleEnabled(false);//禁止缩放
//        //1,设置x  y数据
//        for (int i = 0; i < 12; i++) {
//            Xdata.add((i+1)+"月");
//            float y = (float) (Math.random() * 30);
//            float y2 = (float) (Math.random() * 30);
//            Ydata.add(new Entry(i,y));
//            Ydata2.add(new Entry(i,y2));
//        }
//
//        //2,设置线
//        LineDataSet lineDataSet=new LineDataSet(Ydata,"lable");
//        lineDataSet.setColor(R.color.red);//线条颜色
//        lineDataSet.setCircleColor(R.color.red);//圆点颜色
//        lineDataSet.setLineWidth(1f);//线条宽度
//        lineDataSet.setDrawCircles(false);//不显示点
//        lineDataSet.setDrawValues(false);//不显示点的值
//
//        LineDataSet lineDataSet2=new LineDataSet(Ydata2,"lable");
//        lineDataSet2.setColor(getResources().getColor(R.color.darkorchid));//线条颜色
//        lineDataSet2.setCircleColor(getResources().getColor(R.color.darkorchid));//圆点颜色
//        lineDataSet2.setLineWidth(1f);//线条宽度
//        lineDataSet2.setDrawCircles(false);//不显示点
//        lineDataSet2.setDrawValues(false);//不显示点的值
//
//        YAxis yAxisRight=binding.lineChart.getAxisRight();//获取右边y轴
//        yAxisRight.setEnabled(false);//右边Y轴禁用
//
//        YAxis yAxisLeft=binding.lineChart.getAxisLeft();//获取左边y轴
//        yAxisLeft.setAxisMinimum(0f);
//        yAxisLeft.setAxisMaximum(100f);
//        yAxisLeft.setSpaceBottom(0f);//数据最小值与Y轴最小值的差值
//        yAxisLeft.setSpaceTop(0f);//数据最大值与Y轴最大值的差值
//        yAxisLeft.setGranularity(1f);//禁止放大后x轴标签重绘
//        yAxisLeft.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return value+"";
//            }
//        });//Y轴标签自定义标签
//        yAxisLeft.setLabelCount(5,false);//设置Y轴的分割数量
//
//
//        XAxis xAxis=binding.lineChart.getXAxis();//获取X轴
//        xAxis.setTextColor(R.color.black);
//        xAxis.setTextSize(11f);
//        xAxis.setAxisMinimum(0f);
//        xAxis.setDrawAxisLine(true);//是否绘制轴线
//        xAxis.setDrawGridLines(false);//设置x轴上每个点对应的线
//        xAxis.setDrawLabels(true);//绘制标签  指x轴上的对应数值
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
//        xAxis.setGranularity(1f);//禁止放大后x轴标签重绘
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(Xdata));//x轴标签自定义标签
//        xAxis.setLabelCount(12,false);//设置X轴的分割数量
////        xAxis.setCenterAxisLabels(true);
//
//        //3,设置数据
//        LineData lineData=new LineData(lineDataSet,lineDataSet2);
//        binding.lineChart.setData(lineData);
//        binding.lineChart.invalidate();
//
//
//        //设置点击样式
//        LineChartMarkView lineChartMarkView=new LineChartMarkView(this,xAxis.getValueFormatter());
//        lineChartMarkView.setChartView(binding.lineChart);
//        binding.lineChart.setMarker(lineChartMarkView);
//        binding.lineChart.invalidate();
//    }
//
//    private List<String> strings=new ArrayList<>();
//    private List<BarEntry> yValues =new ArrayList<>();
//    private List<BarEntry> yValues2 =new ArrayList<>();
//
//    private void initBarChart(){
//
//        binding.BarChart.setScaleEnabled(false);//禁止缩放
////        binding.BarChart.groupBars(0.0f,0.06f,0.02f);
//        //1,设置x  y数据
//        for (int i = 0; i < 5; i++) {
//            strings.add((i+1)+"月");
//            float y = (float) (Math.random() * 30);
//            yValues .add(new BarEntry(i,y));
//
//            float y2 = (float) (Math.random() * 30);
//            yValues2 .add(new BarEntry(i,y2));
//        }
//        //条形
//        BarDataSet barDataSet=new BarDataSet(yValues,"条形图");
//        barDataSet.setColor(getResources().getColor(R.color.red));
//        BarDataSet barDataSet2=new BarDataSet(yValues2,"条形图2");
//        barDataSet2.setColor(getResources().getColor(R.color.saddlebrown));
////        barDataSet.setValueTextSize(9f);
//
//
////        barDataSet.setFormLineWidth(1f);
////        barDataSet.setFormSize(15.f);
//
//        YAxis axisRight=binding.BarChart.getAxisRight();
//        axisRight.setEnabled(false);//右边Y轴禁用
//
//        YAxis axisLeft=binding.BarChart.getAxisLeft();
//        axisLeft.setAxisMaximum(30f);
//        axisLeft.setAxisMinimum(0f);
//        axisLeft.setSpaceTop(0f);
//        axisLeft.setSpaceBottom(0f);
//        axisLeft.setLabelCount(4,false);
//
//        XAxis xAxis=binding.BarChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        // 取消 垂直 网格线
//        xAxis.setDrawGridLines(false);
//        xAxis.setLabelCount(yValues.size()+1,false);
////        xAxis.setCenterAxisLabels(true);
//        xAxis.setAxisMinimum(-0.5f);
//        xAxis.setAxisMaximum(strings.size());
//        xAxis.setGranularity(1f);
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(strings));
//        //单柱状图
////        BarData barData=new BarData(barDataSet);
////        binding.BarChart.setData(barData);
////        binding.BarChart.invalidate();
//
//        //多柱状图
//        xAxis.setAxisMinimum(0f);
//        xAxis.setCenterAxisLabels(true);
//        BarData barData=new BarData(barDataSet,barDataSet2);
//        int barAmount = 2; //需要显示柱状图的类别 数量
//        float groupSpace = 0.1f; //柱状图组之间的间距
//        float barWidth = (1f - groupSpace) / barAmount;
//        float barSpace = 0f;
//        //设置柱状图宽度
//        barData.setBarWidth(barWidth);
//        //(起始点、柱状图组间距、柱状图之间间距)
//        barData.groupBars(0f, groupSpace, barSpace);
//        binding.BarChart.setData(barData);
//        binding.BarChart.invalidate();
//    }
//
//    private List<PieEntry> YPievals=new ArrayList<>();
//    private List<Integer> colors=new ArrayList<>();
//
//    private void initPieChart(){
//
//
//        //设置数据
//        YPievals.add(new PieEntry(30,"哈哈"));
//        YPievals.add(new PieEntry(20,"呵呵"));
//        YPievals.add(new PieEntry(25,"嘻嘻"));
//        YPievals.add(new PieEntry(25,"哦哦"));
//        colors.add(Color.RED);
//        colors.add(Color.BLUE);
//        colors.add(Color.DKGRAY);
//        colors.add(Color.MAGENTA);
//
//        PieDataSet pieDataSet=new PieDataSet(YPievals,"");
//        pieDataSet.setColors(colors);
//        //设置个饼状图之间的距离
//        pieDataSet.setSliceSpace(3f);
//        // 部分区域被选中时多出的长度
//        pieDataSet.setSelectionShift(5f);
//
//        //提示字体大小
//        pieDataSet.setValueTextSize(18f);
//        //提示字体颜色
//        pieDataSet.setValueTextColor(getResources().getColor(R.color.white));
//        //Y的值现在饼上还是再饼外
//        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);
//
//        //OUTSIDE_SLICE饼外 时
//        //设置提示区域的线开始点距离圆形偏离百分比
//        pieDataSet.setValueLinePart1OffsetPercentage(80.f);
//        //再环内部分线的长
//        pieDataSet.setValueLinePart1Length(0.6f);
//        //再环外部分线的长
//        pieDataSet.setValueLinePart2Length(0.2f);
//        //线的颜色
//        pieDataSet.setValueLineColor(Color.RED);
//        //线的粗细
//        pieDataSet.setValueLineWidth(1);
//
//
//
//        //设置隐藏饼图上文字，只显示百分比
////        binding.PieChart.setDrawEntryLabels(false);
//        //是否显示描述
//        binding.PieChart.getDescription().setEnabled(false);
//        //设置阻尼系数,范围在[0,1]之间,越小饼状图转动越困难
//        binding.PieChart.setDragDecelerationFrictionCoef(0);
//
//        //设置中间文件
//        //  是否显示中间的洞
//        binding.PieChart.setDrawHoleEnabled(false);
//        //设置中间洞的大小
//        binding.PieChart.setHoleRadius(40f);
//
//        // 半透明圈
//        binding.PieChart.setTransparentCircleRadius(50f);
//        // 设置半透明圆圈的颜色
//        binding.PieChart.setTransparentCircleColor(Color.WHITE);
//        //设置半透明圆圈的透明度
//        binding.PieChart.setTransparentCircleAlpha(125);
//
//
//        //是否显示圆盘中间文字，默认显示
//        binding.PieChart.setDrawCenterText(true);
//        //设置圆盘中间文字
//        binding.PieChart.setCenterText("中间文字");
//        //设置圆盘中间文字的大小
//        binding.PieChart.setCenterTextSize(20);
//        //设置圆盘中间文字的颜色
//        binding.PieChart.setCenterTextColor(Color.RED);
//        //设置圆盘中间文字的字体
//        binding.PieChart.setCenterTextTypeface(Typeface.DEFAULT);
//        //设置中间透明圈的半径,值为所占饼图的百分比
////        binding.PieChart.setTransparentCircleRadius(30);
//        //设置pieChart图表文本字体颜色
//        binding.PieChart.setEntryLabelColor(Color.WHITE);
//        //设置pieChart图表文本字体样式
//        //binding.PieChart.setEntryLabelTypeface(Typeface.DEFAULT);
//        //设置pieChart图表文本字体大小
//        //binding.PieChart.setEntryLabelTextSize(10f);
//
//        //是否显示饼图中间空白区域，默认显示
//        binding.PieChart.setDrawHoleEnabled(true);
//        //设置圆盘是否转动，默认转动
//        binding.PieChart.setRotationEnabled(false);
//        //设置初始旋转角度
//        binding.PieChart.setRotationAngle(0);
//
//        //设置比例图
//        Legend mLegend = binding.PieChart.getLegend();
//        //设置比例图显示在饼图的哪个位置
//        mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
//        //设置比例图的形状，默认是方形,可为方形、圆形、线性
//        mLegend.setForm(Legend.LegendForm.CIRCLE);
//        //设置分类代表的值不显示
////        mLegend.setDrawInside(false);
////        mLegend.setEnabled(false);
//
//        //设置X轴动画
//        binding.PieChart.animateX(1800);
//
//        //设置value是否用显示百分数,默认为false
//        binding.PieChart.setUsePercentValues(true);
//
//        PieData pieData=new PieData(pieDataSet);
//        //格式化显示的数据为%百分比
//        pieData.setValueFormatter(new PercentFormatter());
//
//        binding.PieChart.setData(pieData);
//        binding.PieChart.invalidate();
//    }
//    List<RadarEntry> yVals=new ArrayList<>();
//    List<String> xVals=new ArrayList<>();
//    private void initRadarChart(){
//        yVals.add(new RadarEntry(40f));
//        yVals.add(new RadarEntry(30f));
//        yVals.add(new RadarEntry(30f));
//        yVals.add(new RadarEntry(50f));
//        yVals.add(new RadarEntry(20f));
//
//        xVals.add("哈哈");
//        xVals.add("呵呵");
//        xVals.add("嘻嘻");
//        xVals.add("哦哦");
//        xVals.add("嗯嗯");
//
//        Legend l = binding.RadarChart.getLegend();
//        // 图例位置
//        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
//        // 图例字体样式
//        // l.setTypeface(tf);
//        // 图例X间距
//        l.setXEntrySpace(2f);
//        // 图例Y间距
//        l.setYEntrySpace(1f);
//        l.setTextColor(getResources().getColor(R.color.black)); //字体颜色
//
//        XAxis xAxis = binding.RadarChart.getXAxis();
//        // X坐标值字体样式
//        // xAxis.setTypeface(tf);
//        // X坐标值字体大小
//        xAxis.setTextSize(18f);
//        xAxis.setTextColor(getResources().getColor(R.color.blue));
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
//
//        YAxis yAxis = binding.RadarChart.getYAxis();
//        yAxis.setAxisMinimum(0f);
//        yAxis.setAxisMaximum(50f);
//        yAxis.setSpaceBottom(0f);
//        yAxis.setSpaceTop(0f);
//        // Y坐标值字体样式
//        // yAxis.setTypeface(tf);
//        // Y坐标值标签个数
//        yAxis.setLabelCount(4, false);
//        // Y坐标值字体大小
//        yAxis.setTextSize(15f);
//        // Y坐标值是否从0开始
//        yAxis.setStartAtZero(true);
//        // 是否显示y值在图表上
//        yAxis.setDrawLabels(false);
//
//        RadarDataSet set1 = new RadarDataSet(yVals, "虾米手机");
//        // 数据颜色设置
//        set1.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
//        // 实心填充区域颜色
//        set1.setFillColor(ColorTemplate.VORDIPLOM_COLORS[0]);
//        // 是否实心填充区域
//        set1.setDrawFilled(true);
//        // 数据线条宽度
//        set1.setLineWidth(2f);
//
//        RadarData radarData=new RadarData(set1);
//
//        //设置圆盘是否转动，默认转动
//        binding.RadarChart.setRotationEnabled(false);
//        binding.RadarChart.setData(radarData);
//    }
}
