// 시간 자동 입력

package com.example.projectmemo.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // TimeStamped를 상속하여 Entity가 자동으로 데이터베이스 컬럼으로 인식합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
//abstract 상속으로만 메소드를 만드는 것
public abstract class Timestamped {

    @CreatedDate//생성시간
    private LocalDateTime createdAt;

    @LastModifiedDate//수정시간
    private LocalDateTime modifiedAt;
}