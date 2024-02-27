package lab1;

import java.lang.Integer;

public class MyArrayList extends ArrayList{
	
	
	int max(){
		int max = this.size();
		for(int i=0; i < size(); i++) {
			if(max < (Integer)this.get(i)) {
				max = (Integer)this.get(i);
			}
		}
		return max;
	}
	
	
	int min() {
		int min = this.size();
		for(int i = 0; i < size(); i++) {
			if(min > (Integer)this.get(i)) {
				min = (Integer)this.get(i);
			}
		}
		return min;
	}
	
	
	int sum() {
		int sum = 0;
		for(int i = 0; i < size(); i++) {
			sum += (Integer)this.get(i);
		}
		return sum;
	}
	
	
	double avarage() {
		int i = 0,n=0;
		double avarage = this.size();
		for( i = 0; i < size(); i++) {
			n+=(Integer)this.get(i);
		}
		System.out.println(n + " " + i);
		avarage =(double)(n/i);
		return avarage;
	}
	
	
	MyArrayList removeOdd() {
		MyArrayList removeOdd = new MyArrayList();
		int idx = 0;
		for(int i = 0; i < size(); i++) {
				if((Integer)this.get(i)%2 == 0) {
					removeOdd.add(idx, (Integer)this.get(i));
					idx++;
			}
		}
		return removeOdd;
	}
	

//	MyArrayList sort() {
//		MyArrayList s = new MyArrayList();
//		MyArrayList a = new MyArrayList();
//		for(int idx = 0; idx < this.size(); idx++) {
//				a.add(idx, this.get(idx));
//		}
//		
//		int idx = 0;
//		int minIdx;
//		
//		while(a.size() != 0) {
//			minIdx = a.max();
//			for(int i =0; i< a.size()-1; i++) {
//				for(int j = 0; j < a.size(); j++) {
//					if((Integer)this.get(j)-i < minIdx) {
//						minIdx = (Integer)this.get(j);
//					}
//				}
//			}
//			a.remove(a.indexOf(minIdx));
//			s.add(idx, minIdx);
//			idx++;
//		}
//		return s;
//   }
	
	public MyArrayList sort() {
	    MyArrayList sortedList = new MyArrayList();
	    MyArrayList copyList = new MyArrayList();
	    
	    for (int idx = 0; idx < this.size(); idx++) {
	        copyList.add(idx , this.get(idx));
	    }

	    int idx = 0;
	    int minIdx;

	    while (copyList.size() != 0) {
	        minIdx = 0;

	        for (int i = 1; i < copyList.size(); i++) {
	            if ((Integer)copyList.get(i) < (Integer)copyList.get(minIdx)) {
	                minIdx = i;
	            }
	        }

	        sortedList.add(idx,copyList.remove(minIdx));
	        idx++;
	    }

	    return sortedList;
	}

	
	MyArrayList unique() {
		MyArrayList temp = new MyArrayList();
		int k = 0;
		for(int i=0;i<size;i++) {
			if(temp.indexOf(this.get(i)) == -1) {
				temp.add(k,  this.get(i));
				k++;
			}
		}
		return temp;
	}
}
