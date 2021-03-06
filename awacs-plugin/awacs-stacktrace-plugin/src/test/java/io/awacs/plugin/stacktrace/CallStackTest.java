/**
 * Copyright 2016 AWACS Project.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.awacs.plugin.stacktrace;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by pixyonly on 2/7/17.
 */
public class CallStackTest {

    Stub1 stub1;

    @Before
    public void init() {
        stub1 = new Stub1();
    }

    @Test
    public void test() {
        CallStack.initStack();
        CallStack.methodEnter("io/awacs/plugin/stacktrace/CallStackTest", "test");
        stub1.stubMethod0();
        CallStack.methodQuit("io/awacs/plugin/stacktrace/CallStackTest", "test");
        System.out.println(CallStack.reset());
    }


    public static class Stub1 {

        public void stubMethod0() {
            CallStack.methodEnter("io/awacs/plugin/stacktrace/CallStackTest$Stub0", "stubMethod0");
            stubMethod1();
            stubMethod3();
            stubMethod4(4);
            stubMethod4(-5);
            CallStack.methodQuit("io/awacs/plugin/stacktrace/CallStackTest$Stub0", "stubMethod0");
        }

        public void stubMethod1() {
            CallStack.methodEnter("io/awacs/plugin/stacktrace/CallStackTest$Stub1", "stubMethod1");
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0)
                    stubMethod2();
            }
            stubMethod4(1);
            CallStack.methodQuit("io/awacs/plugin/stacktrace/CallStackTest$Stub1", "stubMethod1");
        }

        public void stubMethod2() {
            CallStack.methodEnter("io/awacs/plugin/stacktrace/CallStackTest$Stub2", "stubMethod2");
            try {
                stubMethod3();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CallStack.methodQuit("io/awacs/plugin/stacktrace/CallStackTest$Stub2", "stubMethod2");
        }

        public void stubMethod3() {
            CallStack.methodEnter("io/awacs/plugin/stacktrace/CallStackTest$Stub3", "stubMethod3");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CallStack.methodQuit("io/awacs/plugin/stacktrace/CallStackTest$Stub3", "stubMethod3");
        }

        public int stubMethod4(int i) {
            CallStack.methodEnter("io/awacs/plugin/stacktrace/CallStackTest$Stub4", "stubMethod4");
            if (i % 2 == 0) {
                CallStack.methodQuit("io/awacs/plugin/stacktrace/CallStackTest$Stub4", "stubMethod4");
                return 1;
            }
            CallStack.methodQuit("io/awacs/plugin/stacktrace/CallStackTest$Stub4", "stubMethod4");
            return -1;
        }
    }
}
