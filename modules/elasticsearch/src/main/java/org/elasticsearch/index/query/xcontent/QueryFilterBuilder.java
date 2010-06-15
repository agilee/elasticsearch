/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.query.xcontent;

import org.elasticsearch.common.xcontent.builder.XContentBuilder;

import java.io.IOException;

/**
 * A filter that simply wraps a query.
 *
 * @author kimchy (shay.banon)
 */
public class QueryFilterBuilder extends BaseFilterBuilder {

    private final XContentQueryBuilder queryBuilder;

    /**
     * A filter that simply wraps a query.
     *
     * @param queryBuilder The query to wrap as a filter
     */
    public QueryFilterBuilder(XContentQueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
    }

    @Override protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field(QueryFilterParser.NAME);
        queryBuilder.toXContent(builder, params);
    }
}
