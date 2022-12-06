//
// Created by Debraj Ray on 2022-11-06.
//

#ifndef INTERVIEWCPP_UBISOFT_H
#define INTERVIEWCPP_UBISOFT_H

#include <vector>
#include <thread>
#include <iostream>

using namespace std;
class Ubisoft {

public:
void test();

int practice(vector<int> &a);

    uint64_t GetTime()
    {
        std::chrono::time_point<std::chrono::system_clock> now =
                std::chrono::system_clock::now();
        auto duration = now.time_since_epoch();
        auto millis = std::chrono::duration_cast<std::chrono::milliseconds>(duration).count();
        return millis;
    }

    void FixedTick(unsigned int tickLength, unsigned int duration, const std::function<void(uint64_t /* dt */)>& tickCallback)
    {
        unsigned int callCount = duration / tickLength;
        callCount = duration % tickLength == 0 ? callCount : callCount + 1;
        auto t = GetTime();
        auto startTime = t;
        for(unsigned int i=1; i<=callCount; ++i) {
            tickCallback(static_cast<uint64_t>(t - startTime));
            if(i<callCount) {
                // busy loop
                while(GetTime() < t + tickLength) {
                }
                t = GetTime();
            }
        }
    }

    int solution(int tickLength, int duration)
    {
        unsigned int ticks = 0;
        FixedTick(tickLength, duration, [&ticks](uint64_t dt) {
            cout<<"Called at "<<dt<<endl;
            ++ticks;
        });
        return ticks;
    }

};


#endif //INTERVIEWCPP_UBISOFT_H
