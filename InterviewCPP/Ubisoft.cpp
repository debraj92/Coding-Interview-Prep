//
// Created by Debraj Ray on 2022-11-06.
//

#include "Ubisoft.h"
#include <iostream>
#include <unordered_set>

using namespace std;

void Ubisoft::test() {
    cout<<"Hello World"<<endl;
}

int Ubisoft::practice(vector<int> &a) {
    unordered_set<int> s;
    long max = -1000001;
    long min = -max;
    for (int x: a) {
        s.insert(x);
        max = x > max? x : max;
        min = x < min? x : min;
    }
    if(max < 0){
        return 1;
    }
    int i=min+1>1 ? min+1:1;
    for(; i <= max + 1; ++i){
        if(not s.count(i)){
            return i;
        }
    }
}
