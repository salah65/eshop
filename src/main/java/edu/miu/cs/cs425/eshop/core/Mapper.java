package edu.miu.cs.cs425.eshop.core;

import java.util.List;

public interface Mapper <Domain,Request,Response>{
     Response mapToResponse(Domain domain);
     Domain mapToDomain(Request request);
     List<Response> mapToResponses(List<Domain> domains);
}
