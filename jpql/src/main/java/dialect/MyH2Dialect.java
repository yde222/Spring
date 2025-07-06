package dialect;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyH2Dialect extends H2Dialect {

    @Override
    public void initializeFunctionRegistry(FunctionContributions functionContributions) {

        super.initializeFunctionRegistry(functionContributions); // 기본 함수 유지
        // 여기에 우리가 쓰고 싶은 함수 등록
        functionContributions.getFunctionRegistry().register(
                "group_concat", // 사용할 함수 이름
                new StandardSQLFunction("group_concat", StandardBasicTypes.STRING) // 실제 SQL과 반환 타입
        );
    }

}

