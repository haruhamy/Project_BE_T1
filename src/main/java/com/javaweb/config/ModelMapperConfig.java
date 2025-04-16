package com.javaweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Lớp cấu hình để khởi tạo và cấu hình bean ModelMapper
 * Giúp tự động chuyển đổi giữa các lớp Entity <-> DTO trong toàn bộ ứng dụng
 */
@Configuration // Đánh dấu đây là một lớp cấu hình Spring (Spring sẽ quét và load khi khởi động)
public class ModelMapperConfig {

    /**
     * Đăng ký một Bean ModelMapper trong context của Spring
     * Có thể @Autowired ở bất kỳ đâu trong project để sử dụng
     *
     * @return một đối tượng ModelMapper mới
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper(); // Tạo và trả về instance ModelMapper
    }
}

