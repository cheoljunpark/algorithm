#include <stdio.h>

int main() {
	int a, b;
	double A, B;

	scanf("%d %d", &a, &b);

	A = (double)a;
	B = (double)b;

	printf("%.12lf\n", A / B);

	return 0;
}