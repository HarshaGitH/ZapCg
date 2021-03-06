package com.hopper.tests.util.parser;

import com.hopper.tests.model.ShoppingResponse;
import io.restassured.response.Response;
import org.junit.Assert;

/**
 * Parses Shopping API Response.
 */
public class ShoppingResponseParser
{
    public static ShoppingResponse parse(final Response apiResponse)
    {
        Assert.assertNotNull("Shopping API response is null", apiResponse);

        final String propertyId = apiResponse.jsonPath().getString("property_id");
        final String roomId = apiResponse.jsonPath().getString("rooms[0].id[0]");
        final String rateId = apiResponse.jsonPath().getString("rooms[0].rates[0].id[0]");

        final String priceCheckAPI = apiResponse.jsonPath().getString("rooms[0].rates[0].bed_groups[0].links[0].price_check.href");
        final String priceCheckHTTPMethod = apiResponse.jsonPath().getString("rooms[0].rates[0].bed_groups[0].links[0].price_check.method");

        final String paymentOptionsAPI = apiResponse.jsonPath().getString("rooms[0].rates[0].links[0].payment_options.href");
        final String paymentOptionsHTTPMethod = apiResponse.jsonPath().getString("rooms[0].rates[0].links[0].payment_options.method");

        return ShoppingResponse.builder()
                .withPropertyId(propertyId)
                .withRoomId(roomId)
                .withRateId(rateId)
                .withPriceCheckEndPointDetail(priceCheckAPI, priceCheckHTTPMethod)
                .withPaymentOptionsEndPointDetail(paymentOptionsAPI, paymentOptionsHTTPMethod)
                .build();
    }
}
