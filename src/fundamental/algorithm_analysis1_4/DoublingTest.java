package fundamental.algorithm_analysis1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {
	//����N���������λ������ThreeSum.count��ʱ
	public static double timeTrail(int N) {
		int max = 100000;
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(-max, max);
		}
		Stopwatch stopwatch = new Stopwatch();
		ThreeSum.count(a);
		return stopwatch.elapsedTime();
	}
	public static void main(String[] args) {
		int MAX = 1000000;
		int[] ary = new int[100];
		double[] time = new double[100];
		int i = 0;
		//��ӡ����ʱ��ı��
		for(int N = 250; N < MAX; N += N){
			//��ӡ�����ģΪNʱ�������ʱ
			ary[i] = N;
			time[i++] = timeTrail(N);
//			StdOut.printf("%7d %5.1f\n", N, time);
			
		}
		drawStandard(ary, time);
//		drawLog(ary, time);
	}
	public static void testDrawing() {
		int MAX = 99999;
		
		StdDraw.setXscale(0,100000);
		StdDraw.setYscale(0,100000);
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLUE);
		for (int i = 0; i < MAX; i++) {
			StdDraw.point(i, i);
		}
	}
	 //���Ʊ�׼ͼ��
    public static void drawStandard(int[] n,double[] time)
    {
        StdDraw.setXscale(-0.5,1.2*n[n.length-1]/1000.0);
        StdDraw.setYscale(-0.5,time[n.length-1]*1.2);
        //��������ϵ
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(0, 0, 1.1*n[n.length-1]/1000, 0);
        StdDraw.line(0, 0,0, 1.1*time[n.length-1]);
        for(int i=1;i<1.1*n[n.length-1]/1000.0;i++)
            StdDraw.text(i,-0.2,i+"K");
        for(double t=2;t<time[n.length-1]*1.1;t+=2)
            StdDraw.text(-0.2, t, t+"");
        //����ͼ��
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(0.02);
        for(int i=0;i<n.length;i++)
            StdDraw.point(n[i]/1000.0, time[i]);
    }
    //���ƶ���ͼ��
    public static void drawLog(int[] arrN,double[] timeN)
    {
        //��ʱ��ת��Ϊ�����
        double[] timelog=new double[timeN.length];
        for(int i=0;i<timeN.length;i++)
            timelog[i]=Math.log(timeN[i]);
        StdDraw.setXscale(-0.5,1.2*arrN[arrN.length-1]/1000.0);
        StdDraw.setYscale(-0.5,timelog[arrN.length-1]*1.2);
        //��������ϵ
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(0, 0, 1.1*arrN[arrN.length-1]/1000, 0);
        StdDraw.line(0, 0,0, 1.1*timelog[arrN.length-1]);
        for(int i=1;i<1.1*arrN[arrN.length-1]/1000.0;i++)
            StdDraw.text(i,-0.2,i+"K");
        for(double t=0;t<timelog[arrN.length-1]*1.1;t+=timelog[arrN.length-1]/5)
            StdDraw.text(-0.2, t, String.format("%.2f",t));
        //����ͼ��
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(0.02);
        for(int i=0;i<arrN.length;i++)
            StdDraw.point(arrN[i]/1000.0, timelog[i]);
    }
	
}
