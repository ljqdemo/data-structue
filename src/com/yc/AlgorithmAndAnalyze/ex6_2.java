package com.yc.AlgorithmAndAnalyze;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 01�������⣬��֧�޽編
 */
public class ex6_2 {
    /*
     * ������
     */
    public static void main(String[] args) {
        //��������
        System.out.println("�����뱳��������w����Ʒ�ĸ���n");
        Scanner reader = new Scanner(System.in);
        int w = reader.nextInt();// ����������
        int n = reader.nextInt();// ��Ʒ�ĸ���
        int solution=-1;
        BLBag[] p = new BLBag[n];
        System.out.println("���������������Ʒ������s,����w�ͼ�ֵv");
        int weigth;
        int value;
        String pid;
        for (int i = 0; i < n; i++) {
            pid = reader.next();
            weigth = reader.nextInt();
            value = reader.nextInt();
            p[i] = new BLBag(pid, weigth, value);
        }
        // �������ݽ���
        /*
         * ����
         * 001 16 45 002 15 25 003 15 25
         */
        // �㷨��ʼ
        //����״̬���鲢��ʼ��Ϊ��
        Integer[] a=new Integer[n];
        for(int i=0;i<n;i++) a[i]=null;
        //��p���鰴Ȩ������
        sort(p);
        //��ӡ���
        int haha=branchandlimit(p, w,  a, solution);
        System.out.println("���Ž�Ϊ��"+haha);
    }
    /*
     * Ȩ������ѡ������
     */
    public static void sort(BLBag[] p) {
        BLBag t;
        for (int i = 0; i < p.length; i++) {
            int max = i;
            t = p[i];
            for (int j = i; j < p.length; j++) {
                if (t.wi < p[j].wi) {
                    t = p[j];
                    max = j;
                }
            }
            t = p[i];
            p[i] = p[max];
            p[max] = t;

        }
    }
    /*
     * ���Ͻ�ĺ���   ����p ��ǰλ��  ��ǰ��������    ����������ֵ�����������������м�ֵ��
     */
    public static double findbound(BLBag[] p,int i,int weight)
    {
        double value = 0;
        //��״̬λ�������Ʒ��̰���㷨�Ľ⣬�Ͻ纯���Ľ�Ϊ����ֵ+��ǰ������ֵ
        forLOOP:for(int k=i;k<p.length;k++)//ѭ������
        {
            //̰���㷨������⣨�޸İ棩
            if(p[k].weight<weight){
                value=value+p[k].value;
                weight=weight-p[k].weight;
            }else{
                double a=weight*p[k].wi;//��ǰ��ֵ
                value=value+a;
                weight=0;
                break forLOOP;//����ѭ��
            }
        }
        return value;

    }
    /*
     * ��֧�޽編���� �����ֱ�Ϊ��Ʒ����p����������ֵ��״̬���飬��ǰ����λ��i ,���Ž�
     */
    public static int branchandlimit(BLBag[] p,int weight,Integer[] a,double solution)
    {
        //��������
        LinkedList<Node> nodelist=new LinkedList<Node>();
        LinkedList<Node> nodesolution=new LinkedList<Node>();
        nodelist.add(new Node(0, 0, 0));
        nodesolution.add(new Node(0,0,0));
        while(!nodelist.isEmpty())
        {
            //ȡ��Ԫ��
            Node node = nodelist.pop();
            //�ж��������ڵ�Ĳ���������ֵ���ڵ�ǰ���Ž⣬�ڵ�С������ĳ���
            //���ﲻ�õ��ڣ�����Ҫ����
            if(node.getUnbounvalue()+node.getCurrvalue()>solution && node.getIndex()<p.length)
            {
                //��ڵ�
                int leftWeight=node.getCurrweight()+p[node.getIndex()].weight;
                int leftvalue=node.getCurrvalue()+p[node.getIndex()].value;
                Node left=new Node(leftWeight, leftvalue, node.getIndex()+1);
                //������ڵ�ĸ��ڵ�
                left.setFather(node);
                left.setIsleft(true);
                //����ڵ���ӵ����Ž������
                nodesolution.add(left);
                //������ڵ���Ͻ��ֵ
                left.setUnbounvalue((int)findbound(p, node.getIndex(), weight-node.getCurrweight()));
                //��ڵ������С�ڵ��ڱ����ĳ��أ�����ڵ���Ͻ��ֵ�������Ž�
                if(left.getCurrweight()<=weight && left.getUnbounvalue()+left.getCurrvalue()>solution)
                {
                    //���ڵ���������
                    nodelist.add(left);
                    a[node.getIndex()]=1;
                    //������ֵ���¸�ֵ  �������ǽڵ�ĵ�ǰ��ֵ������������Ž�
                    if(left.getCurrvalue()>solution)
                    {
                        solution=left.getCurrvalue();
                        //System.out.println("�������Ʒ�У�"+p[node.getIndex()].pid);
                    }
                }
                //�ҽڵ�   �ҽڵ�����ò���Ҫ̫�࣬�͸��ڵ���
                Node right=new Node(node.getCurrweight(), node.getCurrvalue(), node.getIndex()+1);
                //���ҽڵ���ӵ����Ž������
                right.setFather(node);
                right.setIsleft(false);
                nodesolution.add(right);
                right.setUnbounvalue((int)findbound(p,node.getIndex(),weight-node.getCurrweight()));
                //�ҽڵ���Ͻ��ֵ���ڵ�ǰ���Ž�
                if(right.getUnbounvalue()+node.getCurrvalue()>solution)
                {
                    //����ҽڵ�
                    nodelist.add(right);
                    a[node.getIndex()]=0;
                }
            }
        }

        /*
         * �������Žⷽ��
         */
        pr(nodesolution,(int)solution,p);
        //�������Ž�

        return (int) solution;
    }
    /**
     *
     * @Description: ������Ž�ķ���
     * @param @param nodesolution
     * @return void
     * @throws
     * @author 
     * @date 
     */
    //����Ϊ
    public static void pr(LinkedList<Node> nodesolution,int solution,BLBag[] p)
    {
        int[] a=new int[p.length];
        Node prnode=null;
        //��list��ѭ���������Ž�Ľڵ�
        for(Node node:nodesolution)
        {
            if(node.getCurrvalue()==solution){
                //System.out.println("���Ž�ĸ��ڵ������Ϊ��"+node.getFather().getIndex());
                prnode=node;
            }
        }
        //ѭ���������Žڵ�ĸ��ڵ㣬�ж����Ƿ�Ϊ��ڵ�
        while (prnode.getFather()!=null)
        {
            if(prnode.isIsleft())
            {
                a[prnode.getIndex()-1]=1;
            }
            prnode=prnode.getFather();
        }
        //��ӡ
        for(int i=0;i<p.length;i++)
        {
            if(a[i]==1) System.out.println("��������Ʒ��"+p[i].pid);
        }
    }


}
/*
 * ������
 */
class BLBag {
    public int weight;// ����
    public int value;// ��ֵ
    public double wi;// Ȩ��
    public String pid;// ��������
    public BLBag(String pid, int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.pid = pid;
        this.wi = (double) value / weight;
    }
}
/**
 *
 * ClassName: Node
 * @Description: �ڵ���
 * @author 
 * @date 
 */
class Node
{
    //��ǰ��Ʒ������
    private int currweight;//��ǰ����
    private int currvalue;//��ǰ��ֵ
    private int unbounvalue;//�Ͻ��ֵ
    private int index;//����
    private Node father;//���ڵ�
    private boolean isleft;//�Ƿ�Ϊ��ڵ�
    public boolean isIsleft() {
        return isleft;
    }
    public void setIsleft(boolean isleft) {
        this.isleft = isleft;
    }
    public Node getFather() {
        return father;
    }
    public void setFather(Node father) {
        this.father = father;
    }
    public int getCurrweight() {
        return currweight;
    }
    public void setCurrweight(int currweight) {
        this.currweight = currweight;
    }
    public int getCurrvalue() {
        return currvalue;
    }
    public void setCurrvalue(int currvalue) {
        this.currvalue = currvalue;
    }
    public int getUnbounvalue() {
        return unbounvalue;
    }
    public void setUnbounvalue(int unbounvalue) {
        this.unbounvalue = unbounvalue;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    //���캯��
    public Node(int currweight,int currvalue,int index)
    {
        this.currweight=currweight;
        this.currvalue=currvalue;
        this.index=index;
    }

}