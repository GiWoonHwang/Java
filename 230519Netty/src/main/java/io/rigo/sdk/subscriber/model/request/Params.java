package io.rigo.sdk.subscriber.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Params {
    private String query;
}
