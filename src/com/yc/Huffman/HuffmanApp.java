package com.yc.Huffman;
/**
 * ������
 * @author 29226
 *
 */
public class HuffmanApp {
	
	public static void main(String[] args) {
			/**
			 *  A  B  C  D  E  F  G  data
			 * 	2  1  3  5  6  2  8  priority 
			 */
			String [] data= {"A","B","C","D","E","F","G"};
			int [] priority= {2,1,3,5,6,2,8};
			priorityQu qu=new priorityQu(data.length*2);
			for(int i=0,n=data.length;i<n;++i) {
				Node item=new Node();
				item.data=data[i];
				item.priority=priority[i];
				qu.insert(item);
			}
			HuffmanTree  huffmantree=new HuffmanTree(qu);
			//�������
			huffmantree.prodisplay(huffmantree.root);
			//����
			huffmantree.findAllLeaf(huffmantree.root, "");
			System.out.println();
			//ȡֵ
			System.out.println(huffmantree.codes);
	}

}
