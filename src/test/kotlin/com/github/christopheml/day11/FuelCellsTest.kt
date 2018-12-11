package com.github.christopheml.day11

import com.github.christopheml.common.Point
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FuelCellsTest {

    @Test
    internal fun cell_value_acceptance_test() {
        assertThat(FuelCells(8).valueAt(3, 5)).isEqualTo(4)
        assertThat(FuelCells(57).valueAt(122, 79)).isEqualTo(-5)
        assertThat(FuelCells(39).valueAt(217, 196)).isEqualTo(0)
        assertThat(FuelCells(71).valueAt(101, 153)).isEqualTo(4)
    }

    @Test
    internal fun highest_location_acceptance_test() {
        assertThat(FuelCells(18).locateHighestChargedCell()).isEqualTo(Point(33, 45))
        assertThat(FuelCells(42).locateHighestChargedCell()).isEqualTo(Point(21, 61))
    }

}
