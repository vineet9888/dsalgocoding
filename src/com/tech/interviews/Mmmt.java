package com.tech.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class Mmmt {


}

class SearchController {

    SearchService searchService;
    // autowired
    SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    //post
    public SearchResponse searchElement(SearchDto searchDto) {
        return searchService.searchElement(searchDto);
    }
}

interface SearchService {
    SearchResponse searchElement(SearchDto searchDto);
}

class SearchServiceImpl implements SearchService {

    private SearchFactory searchFactory;

    SearchServiceImpl(SearchFactory searchFactory) {
        this.searchFactory = searchFactory;
    }

    @Override
    public SearchResponse searchElement(SearchDto searchDto) {
        SearchAlgoService searchAlgoService = searchFactory.getAlgoServiceByType(searchDto.searchType);
        SearchResponse response = new SearchResponse();
        if(searchAlgoService != null) {
            long startTime = System.currentTimeMillis();
            response.status = searchAlgoService.search(searchDto.element);
            long endTime = System.currentTimeMillis();
            response.timeTakenInMillis = (endTime-startTime);
        }
        return response;
    }
}

class SearchFactory {

    Map<SearchType , SearchAlgoService> factoryMap = new HashMap<>();
    SearchFactory(List<SearchAlgoService> searchAlgoServices) {
        searchAlgoServices.forEach((searchAlgoService -> {
            factoryMap.put(searchAlgoService.getType() , searchAlgoService);
        }));
    }

    public SearchAlgoService getAlgoServiceByType(SearchType searchType) {
        return factoryMap.get(searchType);
    }
}

interface SearchAlgoService {
    boolean search(int element);
    SearchType getType();
}

class DataSource {
    public static List<Integer> getList() {
        return new ArrayList<>();
    }
}

class BinarySearch implements SearchAlgoService {

    List<Integer> list = new ArrayList<>();
    BinarySearch() {
        initializeList();
    }

    private void initializeList() {
        list = DataSource.getList();
        Collections.sort(list);
    }

    @Override
    public boolean search(int element) {
        int res = Collections.binarySearch(list , element);
        return res < 0 ? false : true;
    }

    @Override
    public SearchType getType() {
        return SearchType.BINARY_SEARCH;
    }
}

class HashSearch implements SearchAlgoService {

    Set<Integer> set = new HashSet<>();

    HashSearch() {
        initializeSet();
    }

    private void initializeSet() {
        set = DataSource.getList().stream().collect(Collectors.toSet());
    }

    @Override
    public boolean search(int element) {
        return set.contains(element);
    }

    @Override
    public SearchType getType() {
        return SearchType.HASH_SEARCH;
    }
}



class SearchResponse {
    boolean status;
    long timeTakenInMillis;
}

class SearchDto {
    int element;
    SearchType searchType;

}

enum SearchType {
    BINARY_SEARCH,
    LINEAR_SEARCH,
    HASH_SEARCH;
}


