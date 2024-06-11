# 1. 安装CMake

1. 命令行安装

2. 源码安装

3. 二进制包安装

   查看版本

   ```powershell
   cmake --version
   ```

   CMake官网：https://cmake.org/

# 2. 编译一个简单的程序

main.cpp

```c++
#include <iostream>

int main()
{
    std::cout << "hello world" << std::endl;
    return 0;
}
```

CMake编译流程

1. 编写CMakeLists.txt
2. 执行cmake PATH 生成 Makefile (注：PATH为CMakeList.txt所在目录)
3. 执行make编译

## 2.1 编写CMakeList.txt

```cmake
add_executable(main main.cpp)
```

说明

- add_executable:使用指定的源文件来生成目标可执行文件

## 2.2 生成Makefile文件

```powershell
cmake .
```

## 2.3 编译项目

```powershell
make
```

## 2.4 修复警告

```cmake
cmake_minimum_required(VERSION 3.14)

project(hello)

add_executable(main main.cpp)
```

- cmake_minimum_required:用于设定CMake的最低版本
- project:指定工程名称

## 2.5 语言版本

有时候代码中用到了c++新版的特性，像C++11, C++14, C++17等等。

```cmake
# 增加 -std=c++11
set(CMAKE_CXX_STANDARD 11)

# 增加 -std=c++14
set(CMAKE_CXX_STANDARD 14)

# 增加 -std=c++17
set(CMAKE_CXX_STANDARD 17)
```

## 2.6 编译选项

CMakeList.txt

```cmake
add_compile_options(-g -Wunused)
```

说明

- add_compile_options:给后续的目标加上编译选项

CMakeList.txt

```cmake
target_compile_options(main PUBLIC -Wall -Werror)
```

说明

- target_compile_options:给指定的目标加上编译选项

# 2. 多文件编译

## 2.1 单个添加

add.h

```c++
#pragma once

int add(int x, int y);
```

add.cpp

```c++
#include "add.h"

int add(int x, int y)
{
    return x + y;
}
```

main.cpp

```C++
#include <iostream>
#include "add.h"

int main()
{
    int res = add(1, 2);
    std::cout << "1 + 2 = " << res << std::endl;
    return 0;
}
```

CMakeLists.txt

```C++
cmake_minimum_required(VERSION 3.14)

project(hello)

add_executable(main add.cpp main.cpp)
```

sub.h

```C++
#pragma once

int sub(int x, int y);
```

sub.cpp

```C++
#include "sub.h"

int sub(int x, int y)
{
    return x - y;
}
```

main.cpp

```C++
#include <iostream>
#include "add.h"
#include "sub.h"

int main()
{
    int res = add(1, 2);
    std::cout << "1 + 2 = " << res << std::endl;

    res = sub(9, 1);
    std::cout << "9 - 1 = " << res << std::endl;
    return 0;
}
```

CMakeLists.txt

```C++
cmake_minimum_required(VERSION 3.14)

project(hello)

add_executable(main add.cpp sub.cpp main.cpp)
```

## 2.2 自动添加

自动把src目录下的cpp文件添加到项目里

CMakeList.txt

```C++
cmake_minimum_required(VERSION 3.14)

project(hello)

file(GLOB_RECURSE SOURCES "src/*.cpp")

add_executable(main ${SOURCES} main.cpp)
```

说明

file: 获取src目录下所有.cpp文件，并将其保存到变量中

问题：如果源文件分布在多个目录下怎么办？

```cmake
file(GLOB_RECURSE SOURCES "src/*.cpp" "src1/*.cpp")
```

## 2.3 包含头文件

CMakeLists.txt

```C++
cmake_minimum_required(VERSION 3.14)

project(hello)

include_directories(./)

file(GLOB_RECURSE SOURCES "src/*.cpp")

add_executable(main ${SOURCES} main.cpp)
```

说明：

- include_directories: 添加头文件搜索路径

问题：如何添加多个头文件搜索路径？

```cmake
include_directories(./ ./include)
```

# 3. 多目标编译

test.cpp

```C++
#include <iostream>
#include "add.h"

int main()
{
    int res = add(2, 3);
    std::cout << "2 + 3 = " << res << std::endl;
    return 0;
}
```

CMakeLists.txt

```C++
cmake_minimum_required(VERSION 3.14)
project(hello)
set(CMAKE_CXX_STANDARD 11)

include_directories(./)

file(GLOB_RECURSE SOURCES "src/*.cpp")

add_executable(main ${SOURCES} main.cpp)
add_executable(test ${SOURCES} test.cpp)
```

编译将会生成两个可执行文件：main、test

# 4. 静态库编译&链接

## 4.1 编译

mul/mul.h

```C++
#pragma once

int mul(int x, int y);
```

mul/mul.cpp

```C++
#include "mul.h"

int mul(int x, int y)
{
    return x * y;
}
```

CMakeLists.txt

```C++
set(MUL_SOURCES ./mul/mul.cpp)
add_library(mul STATIC ${MUL_SOURCES})
```

说明

- add_library: 指定从某些源文件创建文件（静态库、动态库）

## 4.2 链接

main.cpp

```C++
#include <iostream>
#include "add.h"
#include "sub.h"
#include "mul.h"

int main()
{
    int res = add(1, 2);
    std::cout << "1 + 2 = " << res << std::endl;

    res = sub(9, 1);
    std::cout << "9 - 1 = " << res << std::endl;

    res = mul(3, 5);
    std::cout << "3 * 5 = " << res << std::endl;
    return 0;
}
```

CMakeLists.txt

```C++
link_directories(./)
link_libraries(mul)
```

或者

```C++
target_link_directories(main PUBLIC ./)
target_link_libraries(main mul)
```

# 5. 动态库编译&链接

## 5.1 编译

CMakeLists.txt

```C++
set(MUL_SOURCES ./mul/mul.cpp)
add_library(mul SHARED ${MUL_SOURCES})
```

说明

- add_library: 指定从某些源文件创建文件（静态库、动态库）

## 5.2 链接

CMakeLists.txt

```C++
link_directories(./)
link_libraries(mul)
```

或者

```C++
target_link_directories(main PUBLIC ./)
target_link_libraries(main mul)
```