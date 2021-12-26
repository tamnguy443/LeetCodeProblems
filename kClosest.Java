/*
December 25th 2021

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

*/

	public static int[][] kClosest(int[][] points, int k) {
		List<ArrayList<Double>> xyDis = new ArrayList<ArrayList<Double>>();

		for (int i = 0; i < points.length; i++) {
			// calculate the distance to the origin
			double d = Math.sqrt((Math.pow(points[i][0] - 0, 2)) + (Math.pow(points[i][1] - 0, 2))); // sqrt (x1 - x2)2
																										// + (y1 -
																										// y2)2).
//			System.out.println(d);
			// store the value along with the INDEX from points to xyDis
			ArrayList<Double> calc = new ArrayList<Double>();
			calc.add(d);
			calc.add((double) i);

			xyDis.add(calc);

		}

//		Collections.sort();
		//sort xyDis but for only sort by the first element of the list which was the distance d
		//calculated from the loop above
		Collections.sort(xyDis, new Comparator<ArrayList<Double>>() {
			@Override
			public int compare(ArrayList<Double> o1, ArrayList<Double> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}
		});
		
//		for (int i = 0; i < xyDis.size(); i++) {
//			System.out.println(xyDis.get(i).get(1));
//		}
		
		int[][] ans = new int[k][2];
		
		for (int i = 0; i < k; i++) {
			//fill ans with K amounts of values from xyDis
			//xyDis.get(i).get(0) is the calcD value
			//xyDis.get(i).get(1) is the index
			//so because xyDis is already in order, just return the first k amount of values from points
			//		using index
			int x = points[xyDis.get(i).get(1).intValue()][0];
			int y = points[xyDis.get(i).get(1).intValue()][1];
			
			ans[i][0] = x;
			ans[i][1] = y;
//			System.out.println(x + ":" + y);
		}

		return ans;

	}

}
