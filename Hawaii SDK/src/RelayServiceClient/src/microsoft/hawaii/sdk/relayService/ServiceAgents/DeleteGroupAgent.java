/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 */
package microsoft.hawaii.sdk.relayService.ServiceAgents;

import java.net.URI;

import microsoft.hawaii.hawaiiClientLibraryBase.HttpMethod;
import microsoft.hawaii.hawaiiClientLibraryBase.ServiceAgent;
import microsoft.hawaii.hawaiiClientLibraryBase.Identities.ClientIdentity;
import microsoft.hawaii.hawaiiClientLibraryBase.Util.UriUtility;
import microsoft.hawaii.hawaiiClientLibraryBase.Util.Utility;
import microsoft.hawaii.sdk.relayService.RelayServiceConst;
import microsoft.hawaii.sdk.relayService.ServiceContracts.GroupResult;

/**
 * Class agent to delete a group.
 */
public class DeleteGroupAgent extends ServiceAgent<GroupResult> {
	/**
	 * Initializes an instance of the {@link DeleteGroupAgent} class
	 * 
	 * @param baseUri
	 *            base URI object
	 * @param registrationId
	 *            the group registrationId
	 * @param identity
	 *            the client identity
	 * @param state
	 *            user defined state object
	 * @throws Exception
	 */
	public DeleteGroupAgent(URI baseUri, String registrationId,
			ClientIdentity identity, Object state) throws Exception {
		super(GroupResult.class, HttpMethod.DELETE, state);
		Utility.assertNotNull("baseUri", baseUri);
		Utility.assertNotNull("identity", identity);

		this.clientIdentity = identity;

		this.serviceUri = new URI(String.format("%s/%s/%s", baseUri,
				RelayServiceConst.GroupSignature,
				UriUtility.safeEncode(registrationId)));
	}

	/*
	 * Override the base method returns false.
	 * 
	 * @see microsoft.hawaii.hawaiiClientLibraryBase.ServiceAgent#
	 * parseServiceResultRequired()
	 */
	@Override
	protected boolean parseServiceResultRequired() {
		return false;
	}
}
