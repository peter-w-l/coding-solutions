package org.pcs.codingsolutions.util.graph;

import lombok.experimental.UtilityClass;

/**
 * Solution for:
 * <p>
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city
 * are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
@UtilityClass
public class ProvincesNumberDeterminer {
    public int countNumberOfProvinces(int[][] citiesConnectionState) {
        int numberOfProvinces = 0;
        boolean[] alreadyIteratedCities = new boolean[citiesConnectionState.length];
        for (int cityNumber = 0; cityNumber < citiesConnectionState.length; cityNumber++) {
            if (!alreadyIteratedCities[cityNumber]) {
                numberOfProvinces ++;
                iterateOverConnectedCities(cityNumber,
                        citiesConnectionState,
                        alreadyIteratedCities);
            }
        }

        return numberOfProvinces;
    }

    private void iterateOverConnectedCities(int currentCityNumber,
                                            int[][] citiesConnectionState,
                                            boolean[] alreadyIteratedCities) {
        alreadyIteratedCities[currentCityNumber] = true;
        int[] currentCityConnectionsState = citiesConnectionState[currentCityNumber];
        for (int cityNumber = 0; cityNumber < currentCityConnectionsState.length; cityNumber++) {
            if (currentCityConnectionsState[cityNumber] == 1 && !alreadyIteratedCities[cityNumber]) {
                iterateOverConnectedCities(cityNumber,
                        citiesConnectionState,
                        alreadyIteratedCities);
            }
        }
    }
}
