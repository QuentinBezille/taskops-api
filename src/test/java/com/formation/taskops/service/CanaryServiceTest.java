package com.formation.taskops.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CanaryServiceTest {

    @Test
    @DisplayName("A 0%, la nouvelle version n'est jamais utilisee")
    void testZeroPourcent() {
        CanaryService canary = new CanaryService(0);
        assertThat(canary.utiliserNouvelleVersion()).isFalse();
        assertThat(canary.getPourcentage()).isZero();
    }

    @Test
    @DisplayName("A 100%, la nouvelle version est toujours utilisee")
    void testCentPourcent() {
        CanaryService canary = new CanaryService(100);
        assertThat(canary.utiliserNouvelleVersion()).isTrue();
        assertThat(canary.getPourcentage()).isEqualTo(100);
    }
}
