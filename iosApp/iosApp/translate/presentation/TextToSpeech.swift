//
//  TextToSpeech.swift
//  iosApp
//
//  Created by Szebenyi Gergely on 2025. 05. 20..
//  Copyright © 2025. orgName. All rights reserved.
//

import Foundation
import AVFoundation

struct TextToSpeech {
	
	private let synthesizer = AVSpeechSynthesizer()
	
	func speak(text: String, language: String) {
		let utterance = AVSpeechUtterance(string: text)
		utterance.voice = AVSpeechSynthesisVoice(language: language)
		utterance.volume = 1
		synthesizer.speak(utterance)
	}
}
