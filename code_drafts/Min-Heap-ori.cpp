#include <cstdio>#include <cstdlib>#include <algorithm>#define MAX_HEAP_SIZE 100000using namespace std;//void min_heapify(int i) {//  int smallest = i;//  int lch = i << 1;//  int rch = lch + 1;////  if (lch <= heapsize && H[smallest] > H[lch])//    smallest = lch;//  if (rch <= heapsize && H[smallest] > H[rch])//    smallest = rch;////  if (smallest != i) {//    int temp = H[smallest];//    H[smallest] = H[i];//    H[i] = temp;//    min_heapify(smallest);//  }//}////void build_heap() {//  for (int i = heapsize >> 1; i >= 1; i--) {//    min_heapify(i);//  }//}//void insert(int *H, int heapsize, int x) {//  H[heapsize] = x;////  int ch = heapsize, p = heapsize >> 1;//  while (H[p] > H[ch] && p >= 1) {//    int temp = H[p];//    H[p] = H[ch];//    H[ch] = temp;////    ch = p;//    p = ch >> 1;//  }//}template<typename T>auto insert(T *heap, int heapsize, T &x) -> void {	heap[heapsize] = x;	auto ch = heapsize;	auto p = heapsize >> 1;	while (heap[p] > heap[ch] and p >= 1) {		swap(heap[p], heap[ch]);		ch = p;		p = ch >> 1;	}}int main() {  int n, heapsize = 0;  auto H = new int[100]();  scanf("%d", &n);  for (int i = 0; i < n; i++) {    int x;    scanf("%d", &x);    insert(H, ++heapsize, x);  }  // Add more actions here.  for (int i = 1; i <= n; i++) {    printf("%i ", H[i]);  }  return 0;}