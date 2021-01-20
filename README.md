# Spring Request and Repsonse examples

In the following Spring boot REST application, we inject a request scope bean into a singleton via a proxy class.

This allows us to access to header information (this is the example.. Any information you'd like to centralise during a request) and access this data throughout your service beans.

1. we use a web filter to edit response headers for all incoming requests
2. we inject a request scope bean into a singleton service bean to access request header values
3. we then use a ResponseBodyAdvice ControllerAdvice to add a response header prior to the write body invoke

See the intellij-requests files for the examples of requests to try it out