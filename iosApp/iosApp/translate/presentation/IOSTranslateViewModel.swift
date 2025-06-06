//
//  IOSTranslateViewModel.swift
//  iosApp
//
//  Created by Szebenyi Gergely on 2025. 05. 16..
//  Copyright © 2025. orgName. All rights reserved.
//

import Foundation
import shared

extension TranslateScreen {
	@MainActor class IOSTranslateViewModel: ObservableObject {
		private var historyDataSource: HistoryDataSource
		private var translateUseCase: TranslateUseCase
		
		private let viewModel: TranslateViewModel
		
		@Published var state: TranslateState = TranslateState(
			fromText: "",
			toText: nil,
			isTranslating: false,
			fromLanguage: UiLanguage(language: .english, imageName: "english"),
			toLanguage: UiLanguage(language: .german, imageName: "german"),
			isChoosingFromLanguage: false,
			isChoosingToLanguage: false,
			error: nil,
			history: []
		)
		private var handle: DisposableHandle?
		
		init(historyDataSource: HistoryDataSource, translateUseCase: TranslateUseCase) {
			self.historyDataSource = historyDataSource
			self.translateUseCase = translateUseCase
			self.viewModel = TranslateViewModel(translate: translateUseCase, historyDataSource: historyDataSource, coroutineScope: nil)
		}
		
		func onEvent(event: TranslateEvent) {
			self.viewModel.onEvent(event: event)
		}
		
		func startObserving() {
			handle = viewModel.state.subscribe(onCollect: { state in
				if let state = state {
					self.state = state
				}
			})
		}
		
		func dispose() {
			handle?.dispose()
		}
	}
}
