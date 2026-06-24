cmake_minimum_required(VERSION 3.22.1)
project(secure C)

add_library(secure SHARED secure.c)

find_library(log-lib log)
target_link_libraries(secure ${log-lib})

# Harden the shared object itself.
target_compile_options(secure PRIVATE
        -fvisibility=hidden
        -ffunction-sections
        -fdata-sections
        -O2)
set_target_properties(secure PROPERTIES
        LINK_FLAGS "-Wl,--gc-sections -Wl,--exclude-libs,ALL")
