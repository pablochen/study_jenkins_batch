package com.example.xxlexecutorsample.service;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Service;

@Service  //Service 혹은 Component 필수
public class SampleService {

    @XxlJob("sampleJobHandler")
    public void sampleJobHandlerMethod() {
        String str = "이것도 가능합니다.";
        XxlJobHelper.log("여기에 로그를 작성하면 확인할 수 있습니다. {}", str);
    }

    @XxlJob("sampleJobHandler2")
    public void sampleXxlJob() {
        String str = "이것도 가능합니다.";
        XxlJobHelper.log("여기에 로그를 작성하면 확인할 수 있습니다. {}", str);

        //********* 여기부터 *************
        // param parse
        String param = XxlJobHelper.getJobParam();
        if (param==null || param.trim().length()==0) {
            XxlJobHelper.log("param["+ param +"] invalid.");

            XxlJobHelper.handleFail();
        }

        XxlJobHelper.log("입력된 param은 {} 입니다.", param);
        //********** 여기까지 추가!! *************
    }
}